package com.library.rest.controller;

import com.library.rest.entities.Book;
import com.library.rest.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
}
