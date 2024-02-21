package me.account.account.server.mapper;

import java.util.List;
import me.account.account.server.po.EconomicAttributes;
import me.account.account.server.po.example.EconomicAttributesExample;
import org.apache.ibatis.annotations.Param;

public interface EconomicAttributesMapper {
    long countByExample(EconomicAttributesExample example);

    int deleteByExample(EconomicAttributesExample example);

    int deleteByPrimaryKey(Integer economicAttributeId);

    int insert(EconomicAttributes record);

    int insertSelective(EconomicAttributes record);

    List<EconomicAttributes> selectByExample(EconomicAttributesExample example);

    EconomicAttributes selectByPrimaryKey(Integer economicAttributeId);

    int updateByExampleSelective(@Param("record") EconomicAttributes record, @Param("example") EconomicAttributesExample example);

    int updateByExample(@Param("record") EconomicAttributes record, @Param("example") EconomicAttributesExample example);

    int updateByPrimaryKeySelective(EconomicAttributes record);

    int updateByPrimaryKey(EconomicAttributes record);
}