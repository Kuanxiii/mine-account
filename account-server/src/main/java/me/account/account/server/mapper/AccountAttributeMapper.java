package me.account.account.server.mapper;

import me.account.account.server.po.AccountAttribute;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountAttribute record);

    int insertSelective(AccountAttribute record);

    AccountAttribute selectByPrimaryKey(Integer id);

    @Select("select * from account_attribute where attribute_level = #{attributeLevel}")
    List<AccountAttribute> selectByAttributeLevel(@Param("attributeLevel") Integer attributeLevel);

    @Select("select * from account_attribute where sup_attribute_id = #{supAttributeId}")
    List<AccountAttribute> selectBySupAttributeId(@Param("supAttributeId") Integer supAttributeId);

    int updateByPrimaryKeySelective(AccountAttribute record);

    int updateByPrimaryKey(AccountAttribute record);
}