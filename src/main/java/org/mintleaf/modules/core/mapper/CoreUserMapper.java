package org.mintleaf.modules.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.mintleaf.modules.core.domain.CoreUser;

import java.util.List;

public interface CoreUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoreUser record);

    int insertSelective(CoreUser record);

    CoreUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoreUser record);

    int updateByPrimaryKey(CoreUser record);

    int deleteBatch(@Param("ids") List<Integer> ids);

    CoreUser findCoreUserByName(@Param("name") String name);

    List<CoreUser> findAll(@Param("name")String name);
}