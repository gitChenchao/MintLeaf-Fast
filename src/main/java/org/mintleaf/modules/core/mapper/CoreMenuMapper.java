package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreMenu;

import java.util.List;

public interface CoreMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreMenu record);

    int insertSelective(CoreMenu record);

    CoreMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreMenu record);

    int updateByPrimaryKey(CoreMenu record);

    List<CoreMenu> findAll(@Param("name")String name);

    int deleteBatch(@Param("ids") List<Integer> ids);

    List<CoreMenu> findMenuByNameSample(@Param("name")String name);
}