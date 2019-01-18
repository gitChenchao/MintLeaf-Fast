package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mintleaf.modules.core.domain.CoreUser;
import org.mintleaf.modules.core.mapper.CoreUserMapper;
import org.mintleaf.modules.core.service.CoreUserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 类名称：CoreUserServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月27日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreUserServiceImpl implements CoreUserService {

    private final CoreUserMapper coreUserMapper;

    public CoreUserServiceImpl(CoreUserMapper coreUserMapper) {
        this.coreUserMapper = coreUserMapper;
    }

    @Override
    public Boolean save(CoreUser coreUser) {
        coreUser.setCreatetime(new Date());
        return coreUserMapper.insert(coreUser)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return coreUserMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        if (CollectionUtils.isNotEmpty(ids)){
            return coreUserMapper.deleteBatch(ids)>0;
        }
        return false;
    }

    @Override
    public CoreUser getCoreUserById(Integer id) {
        return coreUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public CoreUser findCoreUserByName(String name) {
        return coreUserMapper.findCoreUserByName(name);
    }

    @Override
    public List<CoreUser> findAll(String name) {
        return coreUserMapper.findAll(name);
    }

    @Override
    public Boolean updateCoreUser(CoreUser coreUser) {
        return coreUserMapper.updateByPrimaryKeySelective(coreUser)>0;
    }
}
