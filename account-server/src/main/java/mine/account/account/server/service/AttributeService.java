package mine.account.account.server.service;

import mine.account.account.server.constants.AttributeConstants;
import mine.account.account.server.dto.AttributeDTO;
import mine.account.account.server.mapper.EconomicAttributesMapper;
import mine.account.account.server.mapper.PurposeAttributesMapper;
import mine.account.account.server.po.AbstractAttributePO;
import mine.account.account.server.po.EconomicAttributes;
import mine.account.account.server.po.PurposeAttributes;
import mine.account.account.server.po.example.EconomicAttributesExample;
import mine.account.account.server.po.example.PurposeAttributesExample;
import mine.account.account.server.utils.ExcelHelper;
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

@Service
public class AttributeService {

    @Resource
    private EconomicAttributesMapper economicAttributesMapper;

    @Resource
    private PurposeAttributesMapper purposeAttributesMapper;

    public int addAttribute(AttributeDTO attributeDTO){
        return insertSelective(attributeDTO.toPOJO());
    }

    @Transactional
    public void batchAddAttribute(List<AttributeDTO> attributeDTOs){
        attributeDTOs.forEach(attributeDTO -> insertSelective(attributeDTO.toPOJO()));
    }

    public List<AttributeDTO> getAllEconomicAttribute(String userCode){
        List<AttributeDTO> attributeDTOs = new ArrayList<>();
        // todo 应该做userCode->userId的转换，当前还未添加用户维度
        Integer userId = 1;
        EconomicAttributesExample example = new EconomicAttributesExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<EconomicAttributes> economicAttributes = economicAttributesMapper.selectByExample(example);
        economicAttributes.forEach(
                attribute -> {
                    AttributeDTO attributeDTO = new AttributeDTO(attribute);
                    attributeDTOs.add(attributeDTO);
                }
        );
        return attributeDTOs;
    }

    public List<AttributeDTO> getAllPurposeAttribute(String userCode){
        List<AttributeDTO> attributeDTOs = new ArrayList<>();
        // todo 应该做userCode->userId的转换，当前还未添加用户维度
        Integer userId = 1;
        PurposeAttributesExample example = new PurposeAttributesExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<PurposeAttributes> purposeAttributes = purposeAttributesMapper.selectByExample(example);
        purposeAttributes.forEach(
                attribute -> {
                    AttributeDTO attributeDTO = new AttributeDTO(attribute);
                    attributeDTOs.add(attributeDTO);
                }
        );
        return attributeDTOs;
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
        for (int i = 0; i < excelNames.size(); i++) {
            if (StringUtils.equalsIgnoreCase(excelNames.get(i), AttributeConstants.RIGID_DEMAND_DESC)){
                rigidDemandColNum = i;
            }
        }

        List<String> rigidDemandData = Arrays.asList("是", "否");

        if (rigidDemandColNum != -1) {
            excelHelper.setDataValidation(rigidDemandData.toArray(new String[0]), 2, 65535, rigidDemandColNum, rigidDemandColNum);
        }
    }




    @Transactional
    public void batchAddByExcel(MultipartFile excelFile){
        Map<Integer, String> titleMap = new HashMap<>();
        List<AttributeDTO> attributeDTOs = new ArrayList<>();
        Map<String, String> excelNameMap = new AttributeDTO().getExcelNameMap();
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

                if (StringUtils.isEmpty(dataMap.get(AttributeConstants.ATTRIBUTE_NAME_DESC))) {
                    continue;
                }

                attributeDTOs.add(new AttributeDTO(dataMap));
            }

            batchAddAttribute(attributeDTOs);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int insertSelective(AbstractAttributePO attributePO){
        if (attributePO instanceof EconomicAttributes) {
            return economicAttributesMapper.insertSelective((EconomicAttributes) attributePO);
        } else if (attributePO instanceof PurposeAttributes) {
            return purposeAttributesMapper.insertSelective((PurposeAttributes) attributePO);
        } else {
            throw new RuntimeException("未知的属性类型");
        }
    }

}
