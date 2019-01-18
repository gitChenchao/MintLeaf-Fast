package org.mintleaf.modules.book.mapper;

import org.junit.Test;
import org.mintleaf.BaseTestCase;
import org.mintleaf.modules.book.domain.Book;
import org.mintleaf.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名称：BookMapperTest<br>
 * 类描述：<br>
 * 创建时间：2019年01月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class BookMapperTest extends BaseTestCase {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void selectByPrimaryKey(){
        Book book = bookMapper.selectByPrimaryKey(1L);
        System.out.println(JsonUtils.getInstance().toJson(book));
    }
}
