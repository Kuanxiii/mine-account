package me.account.account.server.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDTO {
    // day_no,week_no,mouth_no,stat,amount,use_in,main_attribute,attribute,remark
    private Integer id;
    /**
     * 日偏移量
     */
    private Integer dayNo;
    /**
     * 周偏移量
     */
    private Integer weekNo;
    /**
     * 月偏移量
     */
    private Integer mouthNo;
    /**
     * 当日状态
     */
    private String stat;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 使用与某处
     */
    private String useIn;
    /**
     * 主属性
     */
    private Integer mainAttribute;
    /**
     * 其他属性
     */
    private String attribute;
    /**
     * 备注
     */
    private String remark;

}
