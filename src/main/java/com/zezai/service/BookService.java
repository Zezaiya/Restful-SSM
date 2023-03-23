package com.zezai.service;

import com.zezai.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional  //记住,是在接口上添加事务
public interface BookService {
    boolean save(Book book);

    boolean delete(Integer id);

    boolean update(Book book);

    Book getById(Integer id);

    List<Book> getAll();
}
