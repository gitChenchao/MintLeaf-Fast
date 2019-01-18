package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreButton;

import java.util.List;

public interface CoreButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreButton record);

    int insertSelective(CoreButton record);

    CoreButton selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreButton record);

    int updateByPrimaryKey(CoreButton record);

    int deleteBatch(@Param("ids") List<Integer> ids);

    List<CoreButton> findAll();

    List<CoreButton> findButtonByRoleSample(@Param("name") String name);
}