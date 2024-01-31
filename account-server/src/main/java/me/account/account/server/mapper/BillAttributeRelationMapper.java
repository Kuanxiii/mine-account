package me.account.account.server.mapper;

import java.util.List;
import me.account.account.server.po.BillAttributeRelation;
import me.account.account.server.po.example.BillAttributeRelationExample;
import org.apache.ibatis.annotations.Param;

public interface BillAttributeRelationMapper {
    long countByExample(BillAttributeRelationExample example);

    int deleteByExample(BillAttributeRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillAttributeRelation record);

    int insertSelective(BillAttributeRelation record);

    List<BillAttributeRelation> selectByExample(BillAttributeRelationExample example);

    BillAttributeRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillAttributeRelation record, @Param("example") BillAttributeRelationExample example);

    int updateByExample(@Param("record") BillAttributeRelation record, @Param("example") BillAttributeRelationExample example);

    int updateByPrimaryKeySelective(BillAttributeRelation record);

    int updateByPrimaryKey(BillAttributeRelation record);
}