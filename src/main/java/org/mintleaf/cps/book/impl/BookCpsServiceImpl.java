package org.mintleaf.cps.book.impl;

import lombok.extern.slf4j.Slf4j;
import org.mintleaf.cps.book.BookCpsService;
import org.mintleaf.modules.book.domain.Book;
import org.mintleaf.modules.book.service.BookService;
import org.mintleaf.modules.core.domain.CoreLogger;
import org.mintleaf.modules.core.domain.CoreLoggerWithBLOBs;
import org.mintleaf.modules.core.service.CoreLoggerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名称：BookCpsServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2019年01月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class BookCpsServiceImpl implements BookCpsService {

    private final BookService bookService;
    private final CoreLoggerService coreLoggerService;

    public BookCpsServiceImpl(BookService bookService, CoreLoggerService coreLoggerService) {
        this.bookService = bookService;
        this.coreLoggerService = coreLoggerService;
    }

    @Override
    @Transactional(value = "transactionManager",rollbackFor = Exception.class)
    public Boolean testTrans(Book book, CoreLoggerWithBLOBs coreLogger) {
        Boolean resultBook =  bookService.save(book);
        Boolean resultLogger = coreLoggerService.save(coreLogger);
        LOGGER.info("结果resultBook:{},resultLogger:{}",resultBook,resultLogger);
        int a = 10/0;
        return Boolean.TRUE;
    }
}
