package org.mintleaf.modules.core.service;

import org.mintleaf.modules.core.domain.CoreRole;

import java.util.List;

/**
 * 类名称：CoreRoleService<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreRoleService {
    /**
     * 保存
     * @param coreRole
     * @return
     */
    Boolean save(CoreRole coreRole);

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
    CoreRole getCoreRoleById(Integer id);

    /**
     * 获取CoreRole全部记录
     * @return
     */
    List<CoreRole> findAll(String name);

    /**
     * 条件修改
     * @param coreRole
     * @return
     */
    Boolean updateByPrimaryKeySelective(CoreRole coreRole);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    List<CoreRole> findRoleByIdSample(Integer userId);
}
