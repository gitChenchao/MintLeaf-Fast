package org.mintleaf.modules.core.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.mintleaf.BaseTestCase;
import org.mintleaf.modules.core.domain.CoreUser;
import org.mintleaf.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类名称：CoreUserServiceTest<br>
 * 类描述：<br>
 * 创建时间：2019年01月04日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class CoreUserServiceTest extends BaseTestCase {

    @Autowired
    private CoreUserService coreUserService;


    @Test
    public void findAllPage(){
        PageHelper.startPage(1, 1);
        List<CoreUser> users = coreUserService.findAll("");
        PageInfo<CoreUser> pageInfo = new PageInfo<>(users);
        System.out.println(JsonUtils.getInstance().toJson(pageInfo));
    }
}
