package me.account.account.server.po;

import java.io.Serializable;
import java.util.Date;

public class EconomicAttributes extends AbstractAttributePO implements Serializable {
    private Integer economicAttributeId;

    private Date insertTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public EconomicAttributes() {
    }

    public EconomicAttributes(Integer userId, String attributeName, String attributeDesc, Boolean rigidDemand, String remark) {
        this.userId = userId;
        this.attributeName = attributeName;
        this.attributeDesc = attributeDesc;
        this.rigidDemand = rigidDemand;
        this.remark = remark;
    }

    public EconomicAttributes(Integer economicAttributeId, Integer userId, String attributeName, String attributeDesc, Boolean rigidDemand, String remark, Date insertTime, Date updateTime) {
        this.economicAttributeId = economicAttributeId;
        this.userId = userId;
        this.attributeName = attributeName;
        this.attributeDesc = attributeDesc;
        this.rigidDemand = rigidDemand;
        this.remark = remark;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public Integer getEconomicAttributeId() {
        return economicAttributeId;
    }

    public void setEconomicAttributeId(Integer economicAttributeId) {
        this.economicAttributeId = economicAttributeId;
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
}