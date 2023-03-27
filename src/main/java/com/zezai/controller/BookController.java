package com.zezai.controller;


import com.zezai.domain.Book;
import com.zezai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }


    @GetMapping
    public Result getAll() {
        List<Book> bookList=bookService.getAll();
        Integer code=bookList!=null ? Code.GET_OK:Code.GET_ERR;
        String msg=bookList!=null? "":"数据查询失败,请重试";
        return new Result(code,bookList,msg);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        System.out.println(flag);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);  //三目运算,判断是否成功
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book=bookService.getById(id);
        Integer code=book!=null ? Code.GET_OK:Code.GET_ERR;
        String msg=book!=null? "":"数据查询失败,请重试";
        return new Result(code,book,msg);
    }

}
