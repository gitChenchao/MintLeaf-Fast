package org.mintleaf.modules.core.mapper;

import org.junit.Test;
import org.mintleaf.BaseTestCase;
import org.mintleaf.modules.core.domain.CoreButton;
import org.mintleaf.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名称：CoreButtonMapperTest<br>
 * 类描述：<br>
 * 创建时间：2018年12月25日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class CoreButtonMapperTest extends BaseTestCase {
    @Autowired
    private CoreButtonMapper coreButtonMapper;

    @Test
    public void selectByPrimaryKey(){
        CoreButton coreButton = coreButtonMapper.selectByPrimaryKey(1135145);
        System.out.println(JsonUtils.getInstance().toJson(coreButton));
    }
}
