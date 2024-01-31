package me.account.account.server.dto;

import me.account.account.server.annotations.FieldDesc;
import me.account.account.server.constants.AttributeConstants;
import me.account.account.server.constants.CommonConstants;
import me.account.account.server.po.AbstractAttributePO;
import me.account.account.server.po.EconomicAttributes;
import me.account.account.server.po.PurposeAttributes;

import java.io.Serializable;
import java.util.*;


public class AttributeDTO extends AbstractEnableExcelBean implements Serializable {

    private Integer id;

    @FieldDesc(CommonConstants.USER_ID_DESC)
    private Integer userId;

    @FieldDesc(AttributeConstants.ATTRIBUTE_NAME_DESC)
    private String attributeName;

    @FieldDesc(AttributeConstants.ATTRIBUTE_DESC)
    private String attributeDesc;

    /**
     * 需要下拉选择：是否刚需
     */
    @FieldDesc(AttributeConstants.RIGID_DEMAND_DESC)
    private Boolean rigidDemand;

    @FieldDesc(CommonConstants.REMARK_DESC)
    private String remark;

    private Date insertTime;

    private Date updateTime;

    public AbstractAttributePO toPOJO(){
        // 如果rigidDemand为空, 则为用途属性，反之为经济属性
        if (Objects.isNull(rigidDemand)){
            return new PurposeAttributes(userId, this.attributeName, this.attributeDesc, this.remark);
        } else {
            return new EconomicAttributes(userId, this.attributeName, this.attributeDesc, this.rigidDemand, this.remark);
        }
    }

    public AttributeDTO() {
    }

    public AttributeDTO(Integer id, Integer userId, String attributeName, String attributeDesc, Boolean rigidDemand, String remark) {
        this.setId(id);
        this.setUserId(userId);
        this.setAttributeName(attributeName);
        this.setAttributeDesc(attributeDesc);
        this.setRigidDemand(rigidDemand);
        this.setRemark(remark);
    }

    public AttributeDTO(EconomicAttributes economicAttributes) {
        this.setId(economicAttributes.getEconomicAttributeId());
        this.setUserId(economicAttributes.getUserId());
        this.setAttributeName(economicAttributes.getAttributeName());
        this.setAttributeDesc(economicAttributes.getAttributeDesc());
        this.setRigidDemand(economicAttributes.getRigidDemand());
        this.setRemark(economicAttributes.getRemark());
        this.setInsertTime(economicAttributes.getInsertTime());
        this.setUpdateTime(economicAttributes.getUpdateTime());
    }

    public AttributeDTO(PurposeAttributes purposeAttributes) {
        this.setId(purposeAttributes.getPurposeAttributeId());
        this.setUserId(purposeAttributes.getUserId());
        this.setAttributeName(purposeAttributes.getAttributeName());
        this.setAttributeDesc(purposeAttributes.getAttributeDesc());
        this.setRigidDemand(purposeAttributes.getRigidDemand());
        this.setRemark(purposeAttributes.getRemark());
        this.setInsertTime(purposeAttributes.getInsertTime());
        this.setUpdateTime(purposeAttributes.getUpdateTime());
    }

    public AttributeDTO(Map<String, String> map) {
        this.setId(Objects.isNull(map.getOrDefault("id", null)) ? null : Integer.parseInt(map.get("id")));
        this.setAttributeName(Objects.isNull(map.getOrDefault("attributeName", null)) ? null : map.get("attributeName"));
        this.setRigidDemand(Objects.isNull(map.getOrDefault("rigidDemand", null)) ? null : Objects.equals(map.get("rigidDemand"), "是"));
        this.setAttributeDesc(Objects.isNull(map.getOrDefault("attributeDesc", null)) ? null : map.get("attributeDesc"));
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeDesc() {
        return attributeDesc;
    }

    public void setAttributeDesc(String attributeDesc) {
        this.attributeDesc = attributeDesc;
    }

    public Boolean getRigidDemand() {
        return rigidDemand;
    }

    public void setRigidDemand(Boolean rigidDemand) {
        this.rigidDemand = rigidDemand;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
