package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mintleaf.modules.core.domain.CoreRole;
import org.mintleaf.modules.core.mapper.CoreRoleMapper;
import org.mintleaf.modules.core.service.CoreRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称：CoreRoleServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreRoleServiceImpl implements CoreRoleService {

    private final CoreRoleMapper coreRoleMapper;

    public CoreRoleServiceImpl(CoreRoleMapper coreRoleMapper) {
        this.coreRoleMapper = coreRoleMapper;
    }

    @Override
    public Boolean save(CoreRole coreRole) {
        return coreRoleMapper.insert(coreRole)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return coreRoleMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        if (CollectionUtils.isNotEmpty(ids)){
            return coreRoleMapper.deleteBatch(ids)>0;
        }
        return false;
    }

    @Override
    public CoreRole getCoreRoleById(Integer id) {
        return coreRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CoreRole> findAll(String name) {
        return coreRoleMapper.findAll(name);
    }

    @Override
    public Boolean updateByPrimaryKeySelective(CoreRole coreRole) {
        return coreRoleMapper.updateByPrimaryKeySelective(coreRole)>0;
    }

    @Override
    public List<CoreRole> findRoleByIdSample(Integer userId) {
        return coreRoleMapper.findRoleByIdSample(userId);
    }
}
