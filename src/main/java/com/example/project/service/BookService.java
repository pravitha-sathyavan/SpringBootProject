package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.persistance.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    //@Autowired
    public BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book>  findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public List<Book>  findAll(){
        return (List<Book>) bookRepository.findAll();
    }

    public Book  saveBook(Book book){
        return bookRepository.save(book);
    }
}
