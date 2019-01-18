package org.mintleaf.modules.core.service;


import org.mintleaf.modules.core.domain.CoreLoggerWithBLOBs;

import java.util.List;

/**
 * 类名称：CoreLoggerService<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface CoreLoggerService {

    /**
     * 保存
     * @param coreLogger
     * @return
     */
    Boolean save(CoreLoggerWithBLOBs coreLogger);

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
     * 获取coreLogger一条记录通过主键id
     * @param id
     * @return
     */
    CoreLoggerWithBLOBs getCoreLoggerById(Integer id);

    /**
     * 获取coreLogger全部记录
     * @return
     */
    List<CoreLoggerWithBLOBs> findAll();
}
