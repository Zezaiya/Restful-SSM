package com.zezai.service.impl;

import com.zezai.controller.Code;
import com.zezai.dao.BookDao;
import com.zezai.domain.Book;
import com.zezai.exception.BusinessException;
import com.zezai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {

        return bookDao.delete(id) > 0;
    }

    @Override
    public boolean update(Book book) {

        return bookDao.update(book) > 0;
    }

    @Override
    public Book getById(Integer id) {
        if (id == 100) {
            throw new BusinessException(Code.BUSINESS_ERR, "请勿进行非法操作");
        }
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
