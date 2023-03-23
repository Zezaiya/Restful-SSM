package com.zezai.controller;


import com.zezai.domain.Book;
import com.zezai.service.BookService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public boolean save(@RequestBody Book book){
       return bookService.save(book);
    }


    @GetMapping
    public List<Book> getAll(){
      return bookService.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        bookService.delete(id);
        return true;
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        bookService.update(book);
        return true;
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return  bookService.getById(id);
    }

}
