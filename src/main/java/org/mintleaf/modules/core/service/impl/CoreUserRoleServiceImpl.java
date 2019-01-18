package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mintleaf.modules.core.domain.CoreUserRole;
import org.mintleaf.modules.core.mapper.CoreUserRoleMapper;
import org.mintleaf.modules.core.service.CoreUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称：CoreUserRoleServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月27日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreUserRoleServiceImpl implements CoreUserRoleService {
    private final CoreUserRoleMapper coreUserRoleMapper;

    public CoreUserRoleServiceImpl(CoreUserRoleMapper coreUserRoleMapper) {
        this.coreUserRoleMapper = coreUserRoleMapper;
    }

    @Override
    public Boolean save(CoreUserRole coreUserRole) {
        return coreUserRoleMapper.insert(coreUserRole)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return coreUserRoleMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        if (CollectionUtils.isNotEmpty(ids)){
            return coreUserRoleMapper.deleteBatch(ids)>0;
        }
        return false;
    }

    @Override
    public CoreUserRole getCoreUserById(Integer id) {
        return coreUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean deleteByUserId(Integer userId) {
        return coreUserRoleMapper.deleteByUserId(userId)>0;
    }

    @Override
    public List<CoreUserRole> getCoreUserByUserId(Integer userId) {
        return coreUserRoleMapper.getCoreUserByUserId(userId);
    }
}
