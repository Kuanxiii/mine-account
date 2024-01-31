package me.account.account.server.po;

import java.io.Serializable;
import java.util.Date;

public class BillAttributeRelation implements Serializable {
    private Integer id;

    private Integer billId;

    private Integer purposeAttributeId;

    private Date insertTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
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