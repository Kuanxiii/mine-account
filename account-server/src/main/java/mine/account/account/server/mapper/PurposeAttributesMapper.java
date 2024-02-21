package mine.account.account.server.mapper;

import java.util.List;
import mine.account.account.server.po.PurposeAttributes;
import mine.account.account.server.po.example.PurposeAttributesExample;
import org.apache.ibatis.annotations.Param;

public interface PurposeAttributesMapper {
    long countByExample(PurposeAttributesExample example);

    int deleteByExample(PurposeAttributesExample example);

    int deleteByPrimaryKey(Integer purposeAttributeId);

    int insert(PurposeAttributes record);

    int insertSelective(PurposeAttributes record);

    List<PurposeAttributes> selectByExample(PurposeAttributesExample example);

    PurposeAttributes selectByPrimaryKey(Integer purposeAttributeId);

    int updateByExampleSelective(@Param("record") PurposeAttributes record, @Param("example") PurposeAttributesExample example);

    int updateByExample(@Param("record") PurposeAttributes record, @Param("example") PurposeAttributesExample example);

    int updateByPrimaryKeySelective(PurposeAttributes record);

    int updateByPrimaryKey(PurposeAttributes record);
}