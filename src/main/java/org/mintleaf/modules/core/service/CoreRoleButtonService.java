package org.mintleaf.modules.core.service;

import org.mintleaf.modules.core.domain.CoreRoleButton;

import java.util.List;

/**
 * 类名称：CoreRoleButtonService<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreRoleButtonService {

    /**
     * 根据id删除角色按钮关系表所有与roleid关联的数据
     * @param roleId
     * @return
     */
    Boolean deleteSample(Integer roleId);

    /**
     * 保存
     * @param coreRoleButton
     * @return
     */
    Boolean save(CoreRoleButton coreRoleButton);

    /**
     * 根据角色id获取按钮权限
     * @param roleId
     * @return
     */
    List<CoreRoleButton> getCoreRoleButtonByRoleId(Integer roleId);
}
