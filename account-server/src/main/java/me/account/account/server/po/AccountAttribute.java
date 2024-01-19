package me.account.account.server.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountAttribute implements Serializable {
    private Integer id;

    private Integer rigidDemand;

    private Integer attributeLevel;

    private Integer supAttribute;

    private String attributeName;

    private String attributeDesc;

    private static final long serialVersionUID = 1L;
}