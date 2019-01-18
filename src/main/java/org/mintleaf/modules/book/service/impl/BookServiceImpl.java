package org.mintleaf.modules.book.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.mintleaf.modules.book.domain.Book;
import org.mintleaf.modules.book.mapper.BookMapper;
import org.mintleaf.modules.book.service.BookService;
import org.springframework.stereotype.Service;

/**
 * 类名称：BookServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2019年01月03日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book)>0;
    }
}
