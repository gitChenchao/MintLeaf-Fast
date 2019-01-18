package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mintleaf.modules.core.domain.CoreMenu;
import org.mintleaf.modules.core.mapper.CoreMenuMapper;
import org.mintleaf.modules.core.service.CoreMenuService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 类名称：CoreMenuServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreMenuServiceImpl implements CoreMenuService {

    private final CoreMenuMapper coreMenuMapper;

    public CoreMenuServiceImpl(CoreMenuMapper coreMenuMapper) {
        this.coreMenuMapper = coreMenuMapper;
    }

    @Override
    public Boolean save(CoreMenu coreMenu) {
        coreMenu.setCreatetime(new Date());
        return coreMenuMapper.insert(coreMenu)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return coreMenuMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        if (CollectionUtils.isNotEmpty(ids)){
            return coreMenuMapper.deleteBatch(ids)>0;
        }
        return false;
    }

    @Override
    public CoreMenu getCoreMenuById(Integer id) {
        return coreMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CoreMenu> findAll(String name) {
        return coreMenuMapper.findAll(name);
    }

    @Override
    public Boolean updateByPrimaryKeySelective(CoreMenu coreMenu) {
        return coreMenuMapper.updateByPrimaryKeySelective(coreMenu)>0;
    }

    @Override
    public List<CoreMenu> findMenuByNameSample(String roleName) {
        return coreMenuMapper.findMenuByNameSample(roleName);
    }
}
