package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreRoleButton;

import java.util.List;

public interface CoreRoleButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreRoleButton record);

    int insertSelective(CoreRoleButton record);

    CoreRoleButton selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreRoleButton record);

    int updateByPrimaryKey(CoreRoleButton record);

    int deleteSample(@Param("roleId") Integer roleId);

    List<CoreRoleButton> getCoreRoleButtonByRoleId(@Param("roleId") Integer roleId);
}