package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.mintleaf.modules.core.domain.CoreRoleButton;
import org.mintleaf.modules.core.mapper.CoreRoleButtonMapper;
import org.mintleaf.modules.core.service.CoreRoleButtonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称：CoreRoleButtonServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreRoleButtonServiceImpl implements CoreRoleButtonService {

    private final CoreRoleButtonMapper coreRoleButtonMapper;

    public CoreRoleButtonServiceImpl(CoreRoleButtonMapper coreRoleButtonMapper) {
        this.coreRoleButtonMapper = coreRoleButtonMapper;
    }

    @Override
    public Boolean deleteSample(Integer roleId) {
        return coreRoleButtonMapper.deleteSample(roleId)>0;
    }

    @Override
    public Boolean save(CoreRoleButton coreRoleButton) {
        return coreRoleButtonMapper.insert(coreRoleButton)>0;
    }

    @Override
    public List<CoreRoleButton> getCoreRoleButtonByRoleId(Integer roleId) {
        return coreRoleButtonMapper.getCoreRoleButtonByRoleId(roleId);
    }
}
