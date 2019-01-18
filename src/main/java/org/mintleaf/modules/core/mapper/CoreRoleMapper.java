package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreRole;

import java.util.List;

public interface CoreRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreRole record);

    int insertSelective(CoreRole record);

    CoreRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreRole record);

    int updateByPrimaryKey(CoreRole record);

    int deleteBatch(@Param("ids") List<Integer> ids);

    List<CoreRole> findAll(@Param("name")String name);

    List<CoreRole> findRoleByIdSample(@Param("userId") Integer userId);
}