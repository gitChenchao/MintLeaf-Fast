package org.mintleaf.modules.core.service;

import org.mintleaf.modules.core.domain.CoreRoleMenu;

import java.util.List;

/**
 * 类名称：CoreRoleMenuService<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreRoleMenuService {
    /**
     * 保存
     * @param coreRoleMenu
     * @return
     */
    Boolean save(CoreRoleMenu coreRoleMenu);


    /**
     * 通过角色id获取菜单权限
     * @param roleId
     * @return
     */
    List<CoreRoleMenu> getCoreRoleMenuByRoleId(Integer roleId);

    /**
     * 删除角色id关联的权限
     * @param roleId
     * @return
     */
    Boolean deleteCoreMenuByRoleId(Integer roleId);
}
