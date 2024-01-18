package me.account.account.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.account.account.server.mapper.AccountAttributeMapper;
import me.account.account.server.po.AccountAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, Object> addAttribute(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "desc") String desc
    ){
        Map<String, Object> res = new HashMap<>();

        try {
            AccountAttribute attribute = AccountAttribute.builder()
                    .attributeName(name)
                    .attributeDesc(desc)
                    .build();
            accountAttributeMapper.insertSelective(attribute);
        }catch (Exception e){
            log.error("插入失败", e);
            res.put("code", "-1");
            res.put("desc", "插入失败");
        }

        res.put("code", "0");

        return res;
    }
}
