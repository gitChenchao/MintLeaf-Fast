package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mintleaf.modules.core.domain.CoreButton;
import org.mintleaf.modules.core.mapper.CoreButtonMapper;
import org.mintleaf.modules.core.service.CoreButtonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称：CoreButtonServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreButtonServiceImpl implements CoreButtonService {
    private final CoreButtonMapper coreButtonMapper;

    public CoreButtonServiceImpl(CoreButtonMapper coreButtonMapper) {
        this.coreButtonMapper = coreButtonMapper;
    }

    @Override
    public Boolean save(CoreButton coreButton) {
        return coreButtonMapper.insert(coreButton)>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return coreButtonMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        if(CollectionUtils.isNotEmpty(ids)){
            return coreButtonMapper.deleteBatch(ids)>0;
        }
        return Boolean.FALSE;
    }

    @Override
    public CoreButton getCoreButtonById(Integer id) {
        return coreButtonMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CoreButton> findAll() {
        return coreButtonMapper.findAll();
    }

    @Override
    public Boolean updateByPrimaryKeySelective(CoreButton coreButton) {
        return coreButtonMapper.updateByPrimaryKeySelective(coreButton)>0;
    }

    @Override
    public List<CoreButton> findButtonByRoleSample(String roleName) {
        return coreButtonMapper.findButtonByRoleSample(roleName);
    }
}
