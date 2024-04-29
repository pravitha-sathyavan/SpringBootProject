package com.example.project.controller;

import com.example.project.domain.Book;
import com.example.project.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class BookController {
    //@Autowired
    public BookService serviceClass;

    public BookController(BookService serviceClass){
        this.serviceClass = serviceClass;
    }

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return serviceClass.findAll();
    }

    @GetMapping("/books/{title}")
    public List<Book> findByTitle(String title){
        return serviceClass.findByTitle(title);
    }

    @PostMapping(value = "/saveBook", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@Valid @RequestBody Book book) {
        return serviceClass.saveBook(book);
    }



}
