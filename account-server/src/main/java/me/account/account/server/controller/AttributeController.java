package me.account.account.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.account.account.server.dto.AttributeDTO;
import me.account.account.server.dto.ResponseDTO;
import me.account.account.server.service.AttributeService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Resource
    private AttributeService attributeService;

    @PostMapping("add")
    public ResponseDTO<Object> add(@RequestBody AttributeDTO attributeDTO){
        attributeService.addAttribute(attributeDTO);
        return new ResponseDTO<>();
    }

    @PostMapping("batch_add")
    public ResponseDTO<Object> batchAdd(@RequestBody List<AttributeDTO> attributeDTOs){
        attributeService.batchAddAttribute(attributeDTOs);
        return new ResponseDTO<>();
    }

    @GetMapping("get_all_main_attribute")
    public ResponseDTO<List<AttributeDTO>> getAllMainAttribute(){
        ResponseDTO<List<AttributeDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setData(attributeService.getAllMainAttribute());
        return responseDTO;
    }

    @GetMapping("get_attribute_by_sup_id")
    public ResponseDTO<List<AttributeDTO>> getAttributeBySupId(@RequestParam(value = "supAttributeId", required = true) Integer supAttributeId){
        ResponseDTO<List<AttributeDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setData(attributeService.getAttributesBySupAttributeId(supAttributeId));
        return responseDTO;
    }

    @GetMapping("download_excel_template")
    public void downloadExcelTemplate(HttpServletResponse response){
        // 设置响应头
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=AttributeTemplate.xlsx");
        attributeService.getExcelTemplate(response);
    }



    @PostMapping("batch_add_by_excel")
    public ResponseDTO<Object> batchAddByExcel(@RequestParam("excelFile") MultipartFile excelFile){
        attributeService.batchAddByExcel(excelFile);
        return new ResponseDTO<>();
    }

}
