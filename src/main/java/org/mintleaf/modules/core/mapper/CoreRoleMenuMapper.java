package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreRoleMenu;

import java.util.List;

public interface CoreRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreRoleMenu record);

    int insertSelective(CoreRoleMenu record);

    CoreRoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreRoleMenu record);

    int updateByPrimaryKey(CoreRoleMenu record);

    List<CoreRoleMenu> getCoreRoleMenuByRoleId(@Param("roleId") Integer roleId);

    int deleteCoreMenuByRoleId(@Param("roleId")Integer roleId);
}