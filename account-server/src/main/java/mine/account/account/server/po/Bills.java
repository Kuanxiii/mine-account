package mine.account.account.server.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Bills implements Serializable {
    private Integer billId;

    private Integer userId;

    private Integer dayNo;

    private Integer weekNo;

    private Integer mouthNo;

    private String stat;

    private BigDecimal amount;

    private String useIn;

    private Integer economicAttributeId;

    private String remark;

    private Date insertTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDayNo() {
        return dayNo;
    }

    public void setDayNo(Integer dayNo) {
        this.dayNo = dayNo;
    }

    public Integer getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Integer weekNo) {
        this.weekNo = weekNo;
    }

    public Integer getMouthNo() {
        return mouthNo;
    }

    public void setMouthNo(Integer mouthNo) {
        this.mouthNo = mouthNo;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUseIn() {
        return useIn;
    }

    public void setUseIn(String useIn) {
        this.useIn = useIn == null ? null : useIn.trim();
    }

    public Integer getEconomicAttributeId() {
        return economicAttributeId;
    }

    public void setEconomicAttributeId(Integer economicAttributeId) {
        this.economicAttributeId = economicAttributeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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