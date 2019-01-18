package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreUserRole;

import java.util.List;

public interface CoreUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreUserRole record);

    int insertSelective(CoreUserRole record);

    CoreUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreUserRole record);

    int updateByPrimaryKey(CoreUserRole record);

    int deleteBatch(@Param("ids") List<Integer> ids);

    int deleteByUserId(@Param("userId")Integer userId);

    List<CoreUserRole> getCoreUserByUserId(@Param("userId")Integer userId);
}