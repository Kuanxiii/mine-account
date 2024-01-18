package me.account.account.server.dto;

import lombok.Data;

@Data
public class AttributeDTO {

    private Integer id;
    /**
     * 属性名称
     */
    private String attributeName;

    /**
     * 属性描述
     */
    private String attributeDesc;
}
