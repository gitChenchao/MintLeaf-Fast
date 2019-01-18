package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.mintleaf.modules.core.domain.CoreRoleMenu;
import org.mintleaf.modules.core.mapper.CoreRoleMenuMapper;
import org.mintleaf.modules.core.service.CoreRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称：CoreRoleMenuServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreRoleMenuServiceImpl implements CoreRoleMenuService {

    private final CoreRoleMenuMapper coreRoleMenuMapper;

    public CoreRoleMenuServiceImpl(CoreRoleMenuMapper coreRoleMenuMapper) {
        this.coreRoleMenuMapper = coreRoleMenuMapper;
    }

    @Override
    public Boolean save(CoreRoleMenu coreRoleMenu) {
        return coreRoleMenuMapper.insert(coreRoleMenu)>0;
    }

    @Override
    public List<CoreRoleMenu> getCoreRoleMenuByRoleId(Integer roleId) {
        return coreRoleMenuMapper.getCoreRoleMenuByRoleId(roleId);
    }

    @Override
    public Boolean deleteCoreMenuByRoleId(Integer roleId) {
        return coreRoleMenuMapper.deleteCoreMenuByRoleId(roleId)>0;
    }
}
