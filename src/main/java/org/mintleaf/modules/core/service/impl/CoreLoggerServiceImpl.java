package org.mintleaf.modules.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.mintleaf.modules.core.domain.CoreLoggerWithBLOBs;
import org.mintleaf.modules.core.mapper.CoreLoggerMapper;
import org.mintleaf.modules.core.service.CoreLoggerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称：CoreLoggerServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class CoreLoggerServiceImpl implements CoreLoggerService {

    private final CoreLoggerMapper coreLoggerMapper;

    public CoreLoggerServiceImpl(CoreLoggerMapper coreLoggerMapper) {
        this.coreLoggerMapper = coreLoggerMapper;
    }

    @Override
    public Boolean save(CoreLoggerWithBLOBs coreLogger) {
        int result = coreLoggerMapper.insert(coreLogger);
        return result>0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        int result = coreLoggerMapper.deleteByPrimaryKey(id);
        return result>0;
    }

    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        if (CollectionUtils.isNotEmpty(ids)){
            return coreLoggerMapper.deleteBatch(ids)>0;
        }
        return false;
    }

    @Override
    public CoreLoggerWithBLOBs getCoreLoggerById(Integer id) {
        return coreLoggerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CoreLoggerWithBLOBs> findAll() {
        return coreLoggerMapper.findAll();
    }
}
