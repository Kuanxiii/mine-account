package me.account.account.server.dto;

import lombok.*;
import me.account.account.server.annotations.ExcelName;
import me.account.account.server.constants.AccountConstants;
import me.account.account.server.po.BillingAccounts;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO extends AbstractEnableExcelBean implements Serializable {
    // day_no,week_no,mouth_no,stat,amount,use_in,main_attribute,attributes,remark
    private Integer id;

    @ExcelName(AccountConstants.DAY_NO_DESC)
    private Integer dayNo;

    @ExcelName(AccountConstants.WEEK_NO_DESC)
    private Integer weekNo;

    @ExcelName(AccountConstants.MOUTH_NO_DESC)
    private Integer mouthNo;

    @ExcelName(AccountConstants.STAT_DESC)
    private String stat;

    @ExcelName("金额")
    private BigDecimal amount;

    @ExcelName("使用于某处")
    private String useIn;

    @ExcelName(AccountConstants.MAIN_ATTRIBUTE_DESC)
    private AttributeDTO mainAttribute;

    @ExcelName("其他属性")
    private List<AttributeDTO> attributes;

    @ExcelName("备注")
    private String remark;

    public BillingAccounts toPOJO() {
        StringBuilder attributesBuilder = new StringBuilder();
        attributes.forEach(attribute -> attributesBuilder.append(attribute.getId()).append(","));
        attributesBuilder.deleteCharAt(attributesBuilder.length() - 1);
        return BillingAccounts.builder()
                .id(id)
                .dayNo(dayNo)
                .weekNo(weekNo)
                .mouthNo(mouthNo)
                .stat(stat)
                .amount(amount)
                .useIn(useIn)
                .mainAttribute(mainAttribute.getId())
                .attributes(attributesBuilder.toString())
                .remark(remark)
                .build();
    }

}
