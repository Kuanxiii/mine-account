package me.account.account.server.dto;

import me.account.account.server.annotations.FieldDesc;
import me.account.account.server.constants.AccountConstants;
import me.account.account.server.constants.CommonConstants;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class AccountDTO extends AbstractEnableExcelBean implements Serializable {

    private Integer id;

    @FieldDesc(CommonConstants.USER_ID_DESC)
    private Integer userId;

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

    @FieldDesc(AccountConstants.ECONOMIC_ATTRIBUTE_DESC)
    private Integer economicAttributeId;

    @FieldDesc(AccountConstants.PURPOSE_ATTRIBUTES_DESC)
    private List<Integer> purposeAttributeIds;

    @FieldDesc(CommonConstants.REMARK_DESC)
    private String remark;

//    public BillingAccounts toPOJO() {
//        StringBuilder attributesBuilder = new StringBuilder();
//        attributes.forEach(attribute -> attributesBuilder.append(attribute.getId()).append(","));
//        attributesBuilder.deleteCharAt(attributesBuilder.length() - 1);
//        return BillingAccounts.builder()
//                .id(id)
//                .dayNo(dayNo)
//                .weekNo(weekNo)
//                .mouthNo(mouthNo)
//                .stat(stat)
//                .amount(amount)
//                .useIn(useIn)
//                .mainAttribute(mainAttribute.getId())
//                .attributes(attributesBuilder.toString())
//                .remark(remark)
//                .build();
//    }

}
