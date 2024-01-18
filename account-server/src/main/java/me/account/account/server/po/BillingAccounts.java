package me.account.account.server.po;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class BillingAccounts implements Serializable {
    private Integer id;

    private Integer dayNo;

    private Integer weekNo;

    private Integer mouthNo;

    private String stat;

    private BigDecimal amount;

    private String useIn;

    private Integer mainAttribute;

    private String attribute;

    private String remark;

    private static final long serialVersionUID = 1L;

}