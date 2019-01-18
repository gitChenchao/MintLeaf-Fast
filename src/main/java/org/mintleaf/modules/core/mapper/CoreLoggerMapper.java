package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreLogger;
import org.mintleaf.modules.core.domain.CoreLoggerWithBLOBs;

import java.util.List;

public interface CoreLoggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreLoggerWithBLOBs record);

    int insertSelective(CoreLoggerWithBLOBs record);

    CoreLoggerWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreLoggerWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CoreLoggerWithBLOBs record);

    int updateByPrimaryKey(CoreLogger record);

    List<CoreLoggerWithBLOBs> findAll();

    int deleteBatch(@Param("ids") List<Integer> ids);
}