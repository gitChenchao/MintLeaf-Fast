package org.mintleaf.modules.core.service;

import org.mintleaf.modules.core.domain.CoreMenu;

import java.util.List;

/**
 * 类名称：CoreMenuService<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreMenuService {
    /**
     * 保存
     * @param coreMenu
     * @return
     */
    Boolean save(CoreMenu coreMenu);

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
    CoreMenu getCoreMenuById(Integer id);

    /**
     * 获取coreButton全部记录
     * @return
     */
    List<CoreMenu> findAll(String name);

    /**
     * 条件修改
     * @param coreMenu
     * @return
     */
    Boolean updateByPrimaryKeySelective(CoreMenu coreMenu);

    /**
     * 查询用户菜单数据
     * @param roleName
     * @return
     */
    List<CoreMenu> findMenuByNameSample(String roleName);
}
