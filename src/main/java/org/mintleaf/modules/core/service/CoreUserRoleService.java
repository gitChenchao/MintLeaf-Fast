package org.mintleaf.modules.core.service;

import org.mintleaf.modules.core.domain.CoreUserRole;

import java.util.List;

/**
 * 类名称：CoreUserRoleService<br>
 * 类描述：<br>
 * 创建时间：2018年12月27日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreUserRoleService {
    /**
     * 保存
     * @param coreUserRole
     * @return
     */
    Boolean save(CoreUserRole coreUserRole);

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
     * 获取CoreUserRole一条记录通过主键id
     * @param id
     * @return
     */
    CoreUserRole getCoreUserById(Integer id);

    /**
     * 通过用户id删除
     * @param userId
     * @return
     */
    Boolean deleteByUserId(Integer userId);

    /**
     * 通过userId获取集合
     * @param userId
     * @return
     */
    List<CoreUserRole> getCoreUserByUserId(Integer userId);
}
