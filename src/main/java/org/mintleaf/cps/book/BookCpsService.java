package org.mintleaf.cps.book;

import org.mintleaf.modules.book.domain.Book;
import org.mintleaf.modules.core.domain.CoreLogger;
import org.mintleaf.modules.core.domain.CoreLoggerWithBLOBs;

/**
 * 类名称：BookCpsService<br>
 * 类描述：<br>
 * 创建时间：2019年01月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface BookCpsService {

    /**
     * 测试事务
     * @return
     */
    Boolean testTrans(Book book, CoreLoggerWithBLOBs coreLogger);
}
