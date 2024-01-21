package me.account.account.server.dto;

import lombok.*;
import me.account.account.server.annotations.ExcelName;
import me.account.account.server.constants.AttributeConstants;
import me.account.account.server.po.AccountAttribute;

import java.io.Serializable;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDTO extends AbstractEnableExcelBean implements Serializable {

    private Integer id;

    @ExcelName("属性名称")
    private String attributeName;

    /**
     * 需要下拉选择：是否刚需
     */
    @ExcelName(AttributeConstants.RIGID_DEMAND_DESC)
    private Integer rigidDemand;

    /**
     * 需要下拉选择：属性级别
     */
    @ExcelName(AttributeConstants.ATTRIBUTE_LEVEL_DESC)
    private Integer attributeLevel;

    /**
     * 需要下拉选择：上级属性名
     */
    @ExcelName(AttributeConstants.SUP_ATTRIBUTE_NAME)
    private Integer supAttributeId;

    @ExcelName("属性描述")
    private String attributeDesc;

    public AccountAttribute toPOJO(){
        return AccountAttribute.builder()
                .id(id)
                .rigidDemand(rigidDemand)
                .attributeLevel(attributeLevel)
                .supAttributeId(supAttributeId)
                .attributeName(attributeName)
                .attributeDesc(attributeDesc)
                .build();
    }

    public AttributeDTO(Map<String, String> map) {
        this.setId(Objects.isNull(map.getOrDefault("id", null)) ? null : Integer.parseInt(map.get("id")));
        this.setAttributeName(Objects.isNull(map.getOrDefault("attributeName", null)) ? null : map.get("attributeName"));
        this.setRigidDemand(Objects.isNull(map.getOrDefault("rigidDemand", null)) ? null : Integer.parseInt(map.get("rigidDemand")));
        this.setAttributeLevel(Objects.isNull(map.getOrDefault("attributeLevel", null)) ? null : Integer.parseInt(map.get("attributeLevel")));
        this.setSupAttributeId(Objects.isNull(map.getOrDefault("supAttributeId", null)) ? null : Integer.parseInt(map.get("supAttributeId")));
        this.setAttributeDesc(Objects.isNull(map.getOrDefault("attributeDesc", null)) ? null : map.get("attributeDesc"));
    }


    /**
     * @Description: 重写equals方法, 以属性名称为基准
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(attributeName, ((AttributeDTO) obj).attributeName);
    }

    /**
     * @Description: 重写hashCode方法, 以属性名称为基准
     */
    @Override
    public int hashCode() {
        return Objects.hash(attributeName);
    }

}
