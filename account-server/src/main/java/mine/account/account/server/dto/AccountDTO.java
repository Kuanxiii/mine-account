package mine.account.account.server.dto;

import mine.account.account.server.annotations.FieldDesc;
import mine.account.account.server.constants.AccountConstants;
import mine.account.account.server.constants.CommonConstants;
import mine.account.account.server.po.Bills;
import mine.account.account.server.po.PurposeAttributes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AccountDTO extends AbstractEnableExcelBean implements Serializable {

    private Integer id;

    // todo 当前用户id都按1算
    @FieldDesc(CommonConstants.USER_ID_DESC)
    private Integer userId = 1;

    @FieldDesc(AccountConstants.DAY_NO_DESC)
    private Integer dayNo;

    @FieldDesc(AccountConstants.WEEK_NO_DESC)
    private Integer weekNo;

    @FieldDesc(AccountConstants.MOUTH_NO_DESC)
    private Integer mouthNo;

    @FieldDesc(AccountConstants.STAT_DESC)
    private String stat;

    @FieldDesc(AccountConstants.AMOUNT_DESC)
    private BigDecimal amount;

    @FieldDesc(AccountConstants.USE_IN_DESC)
    private String useIn;

    @FieldDesc(AccountConstants.ECONOMIC_ATTRIBUTE_ID_DESC)
    private Integer economicAttributeId;

    @FieldDesc(AccountConstants.ECONOMIC_ATTRIBUTE_NAME_DESC)
    private String economicAttributeName;

    @FieldDesc(AccountConstants.PURPOSE_ATTRIBUTES_DESC)
    private List<PurposeAttributes> purposeAttributes;

    @FieldDesc(CommonConstants.REMARK_DESC)
    private String remark;

    private Date insertTime;

    private Date updateTime;

    public AccountDTO() {
    }

    public AccountDTO(Bills bills){

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
        this.stat = stat;
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
        this.useIn = useIn;
    }

    public Integer getEconomicAttributeId() {
        return economicAttributeId;
    }

    public void setEconomicAttributeId(Integer economicAttributeId) {
        this.economicAttributeId = economicAttributeId;
    }

    public String getEconomicAttributeName() {
        return economicAttributeName;
    }

    public void setEconomicAttributeName(String economicAttributeName) {
        this.economicAttributeName = economicAttributeName;
    }

    public List<PurposeAttributes> getPurposeAttributes() {
        return purposeAttributes;
    }

    public void setPurposeAttributes(List<PurposeAttributes> purposeAttributes) {
        this.purposeAttributes = purposeAttributes;
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
}
