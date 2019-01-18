package org.mintleaf.modules.core.service;

import org.junit.Test;
import org.mintleaf.BaseTestCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：CoreLoggerServiceTest<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class CoreLoggerServiceTest extends BaseTestCase {
    @Autowired
    private CoreLoggerService coreLoggerService;

    @Test
    public void deleteBatch(){
        List<Integer> ids = new ArrayList<>();
        ids.add(988);
        ids.add(987);
        Boolean result = coreLoggerService.deleteBatch(ids);
        System.out.println(result);
    }
}
