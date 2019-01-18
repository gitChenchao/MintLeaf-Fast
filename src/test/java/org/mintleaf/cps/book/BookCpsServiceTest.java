package org.mintleaf.cps.book;

import org.junit.Test;
import org.mintleaf.BaseTestCase;
import org.mintleaf.modules.book.domain.Book;
import org.mintleaf.modules.core.domain.CoreLoggerWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 类名称：BookCpsServiceTest<br>
 * 类描述：<br>
 * 创建时间：2019年01月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class BookCpsServiceTest extends BaseTestCase {
    @Autowired
    private BookCpsService bookCpsService;

    @Test
    public void testTrans(){
        Book book = new Book();
        //book.setId(3L);
        book.setName("明朝那些事Ⅰ");
        book.setPrice(5000L);
        CoreLoggerWithBLOBs logger = new CoreLoggerWithBLOBs();
        logger.setReturn_data("fanhuishuju");
        logger.setHttp_status_code("200");
        logger.setReturm_time("20190103");
        logger.setSession_id("1111111");
        logger.setParam_data("qingqiushuju");
        logger.setClient_ip("127.0.0.1");
        logger.setMethod("asd()");
        logger.setTime(new Date());
        logger.setTime_consuming(100);
        logger.setType("123");
        logger.setUri("/asd/asd");
        bookCpsService.testTrans(book,logger);
    }

}
