package me.account.account.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.account.account.server.dto.AttributeDTO;
import me.account.account.server.dto.ResponseDTO;
import me.account.account.server.service.AttributeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

}
