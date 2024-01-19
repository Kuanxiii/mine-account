package me.account.account.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.account.account.server.dto.ResponseDTO;
import me.account.account.server.dto.TestRequestBodyDTO;
import me.account.account.server.mapper.AccountAttributeMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private AccountAttributeMapper accountAttributeMapper;

    @RequestMapping("/add_attribute")
    public ResponseDTO<Map<String, Object>> addAttribute(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "desc") String desc,
            @RequestBody TestRequestBodyDTO testRequestBodyDTO
    ){
//        try {
//            AccountAttribute attribute = AccountAttribute.builder()
//                    .attributeName(name)
//                    .attributeDesc(desc)
//                    .build();
//            accountAttributeMapper.insertSelective(attribute);
//        }catch (Exception e){
//            log.error("插入失败", e);
//            return ResponseDTO.builder().returnCode("-1").build();
//        }
        Map<String, Object> res = new HashMap<>();
        res.put("str", "String");
//        AttributeDTO attributeDTO = AttributeDTO.builder().id(11).attributeName("qwe").build();
//        res.put("bean", testRequestBodyDTO.getRequestBody());
        Map<String, Object> res11 = new HashMap<>();
        res11.put("test", 123123);
        res11.put("bean", testRequestBodyDTO);
        res.put("map", res11);

        return new ResponseDTO<>("0", "成功", res);
    }

//    @RequestMapping("/test")
//    public TestRequestBodyDTO test(){
//        List<AttributeDTO> attributeDTOList = new ArrayList<>();
//        attributeDTOList.add(AttributeDTO.builder().attributeName("qwe").build());
//        attributeDTOList.add(AttributeDTO.builder().attributeName("asd").build());
//        return TestRequestBodyDTO.builder().attributeDTOList(attributeDTOList).build();
//    }
}
