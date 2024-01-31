package me.account.account.server.controller;

import me.account.account.server.dto.AttributeDTO;
import me.account.account.server.dto.RequestDTO;
import me.account.account.server.dto.ResponseDTO;
import me.account.account.server.service.AttributeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ResponseBody
@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Resource
    private AttributeService attributeService;

    @PostMapping("add")
    public ResponseDTO<Object> add(@RequestBody RequestDTO<AttributeDTO> requestDTO){
        attributeService.addAttribute(requestDTO.getData());
        return new ResponseDTO<>();
    }

    @PostMapping("batch_add")
    public ResponseDTO<Object> batchAdd(@RequestBody RequestDTO<List<AttributeDTO>> requestDTO){
        attributeService.batchAddAttribute(requestDTO.getData());
        return new ResponseDTO<>();
    }

    @GetMapping("get_all_economic_attribute")
    public ResponseDTO<List<AttributeDTO>> getAllEconomicAttribute(){
        ResponseDTO<List<AttributeDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setData(attributeService.getAllEconomicAttribute("1"));
        return responseDTO;
    }

    @GetMapping("get_all_purpose_attribute")
    public ResponseDTO<List<AttributeDTO>> getAllPurposeAttribute(){
        ResponseDTO<List<AttributeDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setData(attributeService.getAllPurposeAttribute("1"));
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
