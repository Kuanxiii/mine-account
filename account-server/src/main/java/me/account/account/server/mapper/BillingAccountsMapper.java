package me.account.account.server.mapper;

import me.account.account.server.po.BillingAccounts;

public interface BillingAccountsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillingAccounts record);

    int insertSelective(BillingAccounts record);

    BillingAccounts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillingAccounts record);

    int updateByPrimaryKey(BillingAccounts record);
}