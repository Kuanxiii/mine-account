package me.account.account.server.service;

import me.account.account.server.constants.AttributeConstants;
import me.account.account.server.dto.AttributeDTO;
import me.account.account.server.mapper.AccountAttributeMapper;
import me.account.account.server.po.AccountAttribute;
import me.account.account.server.utils.ExcelHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AttributeService {

    @Resource
    private AccountAttributeMapper accountAttributeMapper;

    public int addAttribute(AttributeDTO attributeDTO){
        return accountAttributeMapper.insertSelective(attributeDTO.toPOJO());
    }

    @Transactional
    public void batchAddAttribute(List<AttributeDTO> attributeDTOs){
        attributeDTOs.forEach(attributeDTO -> accountAttributeMapper.insertSelective(attributeDTO.toPOJO()));
    }

    public List<AttributeDTO> getAllMainAttribute(){
        List<AttributeDTO> attributeDTOs = new ArrayList<>();
        List<AccountAttribute> accountAttributeList = accountAttributeMapper.selectByAttributeLevel(1);
        accountAttributeList.forEach(
                attribute -> {
                    AttributeDTO attributeDTO = AttributeDTO.builder().
                            attributeName(attribute.getAttributeName()).
                            attributeDesc(attribute.getAttributeDesc()).
                            rigidDemand(attribute.getRigidDemand()).
                            attributeLevel(attribute.getAttributeLevel()).
                            supAttributeId(attribute.getSupAttributeId()).
                            id(attribute.getId()).
                            build();
                    attributeDTOs.add(attributeDTO);
                }
        );
        return attributeDTOs;
    }

    public List<AttributeDTO> getAttributesBySupAttributeId(Integer supAttributeId){
        List<AttributeDTO> attributes = new ArrayList<>();
        List<AccountAttribute> accountAttributeList = accountAttributeMapper.selectBySupAttributeId(supAttributeId);
        accountAttributeList.forEach(
                attribute -> {
                    AttributeDTO attributeDTO = AttributeDTO.builder().
                            attributeName(attribute.getAttributeName()).
                            attributeDesc(attribute.getAttributeDesc()).
                            rigidDemand(attribute.getRigidDemand()).
                            attributeLevel(attribute.getAttributeLevel()).
                            supAttributeId(attribute.getSupAttributeId()).
                            id(attribute.getId()).
                            build();
                    attributes.add(attributeDTO);
                }
        );
        return attributes;
    }


    public void getExcelTemplate(HttpServletResponse response) {
        List<String> excelNames = new AttributeDTO().getExcelNameList();
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Attribute");
            ExcelHelper excelHelper = new ExcelHelper(workbook, sheet);
            // 设置禁止更改声明
            excelHelper.setMergedCellAndRedFont(0, 0, 0, excelNames.size()-1, "请勿修改表头与Sheet名称");
            // 设置表头
            excelHelper.setRowData(1, excelNames);
            // 设置下拉选项框
            setDataValidation(excelNames, excelHelper);

            try (OutputStream outputStream = response.getOutputStream()) {
                workbook.write(outputStream);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setDataValidation(List<String> excelNames, ExcelHelper excelHelper){
        int rigidDemandColNum = -1;
        int attributeLevelColNum = -1;
        int supAttributeNameColNum = -1;
        for (int i = 0; i < excelNames.size(); i++) {
            if (StringUtils.equalsIgnoreCase(excelNames.get(i), AttributeConstants.RIGID_DEMAND_DESC)){
                rigidDemandColNum = i;
            }
            if (StringUtils.equalsIgnoreCase(excelNames.get(i), AttributeConstants.ATTRIBUTE_LEVEL_DESC)){
                attributeLevelColNum = i;
            }
            if (StringUtils.equalsIgnoreCase(excelNames.get(i), AttributeConstants.SUP_ATTRIBUTE_NAME)){
                supAttributeNameColNum = i;
            }
        }

        List<String> rigidDemandData = Arrays.asList("是", "否");
        List<String> attributeLevelData = Arrays.asList("1", "2");
        List<String> supAttributeNameData = getAllMainAttribute().stream().map(AttributeDTO::getAttributeName).collect(Collectors.toList());

        if (rigidDemandColNum != -1) {
            excelHelper.setDataValidation(rigidDemandData.toArray(new String[0]), 2, 65535, rigidDemandColNum, rigidDemandColNum);
        }
        if (attributeLevelColNum != -1) {
            excelHelper.setDataValidation(attributeLevelData.toArray(new String[0]), 2, 65535, attributeLevelColNum, attributeLevelColNum);
        }
        if (supAttributeNameColNum != -1) {
            excelHelper.setDataValidation(supAttributeNameData.toArray(new String[0]), 2, 65535, supAttributeNameColNum, supAttributeNameColNum);
        }
    }




    @Transactional
    public void batchAddByExcel(MultipartFile excelFile){
        Map<Integer, String> titleMap = new HashMap<>();
        List<AttributeDTO> attributeDTOs = new ArrayList<>();
        Map<String, String> excelNameMap = new AttributeDTO().getExcelNameMap();
        List<AttributeDTO> mainAttributes = getAllMainAttribute();
        try(Workbook workbook = new XSSFWorkbook(excelFile.getInputStream())) {
            Sheet sheet = workbook.getSheet("Attribute");
            for(Row row : sheet){
                if (row.getRowNum() == 0) continue;
                if (row.getRowNum() == 1) {
                    row.forEach(cell -> titleMap.put(cell.getColumnIndex(), excelNameMap.getOrDefault(cell.getStringCellValue(), "")));
                    continue;
                }
                Map<String, String> dataMap = new HashMap<>();
                row.forEach(cell -> dataMap.put(titleMap.get(cell.getColumnIndex()), cell.getStringCellValue()));


                // 上级属性名转上级属性id
                if (StringUtils.isNotBlank(dataMap.get("supAttributeId"))) {
                    // Excel表头中的上级属性id对应的是上级属性名，这里需要转换
                    String supAttributeName = dataMap.get("supAttributeId");
                    boolean isFind = false;
                    for (AttributeDTO mainAttribute : mainAttributes) {
                        if (mainAttribute.getAttributeName().equals(supAttributeName)) {
                            dataMap.put("supAttributeId", String.valueOf(mainAttribute.getId()));
                            isFind = true;
                            break;
                        }
                    }
                    if (!isFind) {
                        // todo 这里找不到应该报错，待后续完善报错逻辑
                    }
                } else if(Objects.equals(dataMap.getOrDefault("attributeLevel", "").trim(), "1")) {
                    // 如果是主属性，需要先添加
                    // 添加至数据库，补充主键并塞回mainAttributes以便后续添加子属性
                    // 因为这里已经入库，所以直接continue，不加入批量插入列表
                    AttributeDTO mainAttribute = new AttributeDTO(dataMap);
                    mainAttribute.setId(addAttribute(mainAttribute));
                    mainAttributes.add(mainAttribute);
                    continue;
                }

                attributeDTOs.add(new AttributeDTO(dataMap));
            }

            batchAddAttribute(attributeDTOs);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
