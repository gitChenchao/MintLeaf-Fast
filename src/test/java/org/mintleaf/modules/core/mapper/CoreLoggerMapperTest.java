package org.mintleaf.modules.core.mapper;

import org.junit.Test;
import org.mintleaf.BaseTestCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：CoreLoggerMapperTest<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class CoreLoggerMapperTest extends BaseTestCase {

    @Autowired
    private CoreLoggerMapper coreLoggerMapper;

    @Test
    public void deleteBatch(){
        List<Integer> ids = new ArrayList<>();
        ids.add(990);
        ids.add(989);
        System.out.println(coreLoggerMapper.deleteBatch(ids));
    }
}
