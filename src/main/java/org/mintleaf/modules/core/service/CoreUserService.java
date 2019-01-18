package org.mintleaf.modules.core.service;

import org.mintleaf.modules.core.domain.CoreUser;

import java.util.List;

/**
 * 类名称：CoreUserService<br>
 * 类描述：<br>
 * 创建时间：2018年12月27日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreUserService {
    /**
     * 保存
     * @param coreUser
     * @return
     */
    Boolean save(CoreUser coreUser);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    Boolean deleteById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Boolean deleteBatch(List<Integer> ids);

    /**
     * 获取CoreRole一条记录通过主键id
     * @param id
     * @return
     */
    CoreUser getCoreUserById(Integer id);

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    CoreUser findCoreUserByName(String name);

    /**
     * 查询全部
     * @return
     */
    List<CoreUser> findAll(String name);

    /**
     * 修改
     * @param coreUser
     * @return
     */
    Boolean updateCoreUser(CoreUser coreUser);
}
