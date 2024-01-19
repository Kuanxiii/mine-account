package me.account.account.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.account.account.server.po.AccountAttribute;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDTO {

    private Integer id;
    /**
     * 属性名称
     */
    private String attributeName;

    private Integer rigidDemand;

    private Integer attributeLevel;

    private Integer supAttribute;

    /**
     * 属性描述
     */
    private String attributeDesc;

    public AccountAttribute toPOJO(){
        return AccountAttribute.builder()
                .id(id)
                .rigidDemand(rigidDemand)
                .attributeLevel(attributeLevel)
                .supAttribute(supAttribute)
                .attributeName(attributeName)
                .attributeDesc(attributeDesc)
                .build();
    }
}
