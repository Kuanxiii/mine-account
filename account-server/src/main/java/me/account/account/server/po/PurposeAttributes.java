package me.account.account.server.po;

import java.io.Serializable;
import java.util.Date;

public class PurposeAttributes extends AbstractAttributePO implements Serializable {
    private Integer purposeAttributeId;

    private Date insertTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;


    public PurposeAttributes() {
    }

    public PurposeAttributes(Integer userId, String attributeName, String attributeDesc, String remark) {
        this.userId = userId;
        this.attributeName = attributeName;
        this.attributeDesc = attributeDesc;
        this.remark = remark;
    }

    public PurposeAttributes(Integer purposeAttributeId, Integer userId, String attributeName, String attributeDesc, String remark, Date insertTime, Date updateTime) {
        this.purposeAttributeId = purposeAttributeId;
        this.userId = userId;
        this.attributeName = attributeName;
        this.attributeDesc = attributeDesc;
        this.remark = remark;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public Integer getPurposeAttributeId() {
        return purposeAttributeId;
    }

    public void setPurposeAttributeId(Integer purposeAttributeId) {
        this.purposeAttributeId = purposeAttributeId;
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