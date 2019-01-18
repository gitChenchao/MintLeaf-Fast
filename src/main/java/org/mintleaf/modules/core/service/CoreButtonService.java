package org.mintleaf.modules.core.service;

import org.mintleaf.modules.core.domain.CoreButton;

import java.util.List;

/**
 * 类名称：CoreButtonService<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreButtonService {
    /**
     * 保存
     * @param coreButton
     * @return
     */
    Boolean save(CoreButton coreButton);

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
     * 获取coreButton一条记录通过主键id
     * @param id
     * @return
     */
    CoreButton getCoreButtonById(Integer id);

    /**
     * 获取coreButton全部记录
     * @return
     */
    List<CoreButton> findAll();

    /**
     * 条件修改
     * @param coreButton
     * @return
     */
    Boolean updateByPrimaryKeySelective(CoreButton coreButton);

    /**
     * 根据角色名查询按钮权限
     * @param roleName
     * @return
     */
    List<CoreButton> findButtonByRoleSample(String roleName);
}
