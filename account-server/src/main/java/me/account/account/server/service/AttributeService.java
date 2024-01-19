package me.account.account.server.service;

import me.account.account.server.dto.AttributeDTO;
import me.account.account.server.mapper.AccountAttributeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttributeService {

    @Resource
    private AccountAttributeMapper accountAttributeMapper;

    public void addAttribute(AttributeDTO attributeDTO){
        accountAttributeMapper.insertSelective(attributeDTO.toPOJO());
    }

    @Transactional
    public void batchAddAttribute(List<AttributeDTO> attributeDTOs){
        attributeDTOs.forEach(attributeDTO -> accountAttributeMapper.insertSelective(attributeDTO.toPOJO()));
    }
}
