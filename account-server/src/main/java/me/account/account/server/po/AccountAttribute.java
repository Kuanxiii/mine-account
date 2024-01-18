package me.account.account.server.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AccountAttribute implements Serializable {
    private Integer id;

    private String attributeName;

    private String attributeDesc;

    private static final long serialVersionUID = 1L;
}