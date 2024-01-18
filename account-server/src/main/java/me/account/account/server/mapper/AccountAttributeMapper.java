package me.account.account.server.mapper;

import me.account.account.server.po.AccountAttribute;

public interface AccountAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountAttribute record);

    int insertSelective(AccountAttribute record);

    AccountAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountAttribute record);

    int updateByPrimaryKey(AccountAttribute record);
}