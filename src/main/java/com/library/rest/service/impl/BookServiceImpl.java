package com.library.rest.service.impl;

import com.library.rest.entities.Book;
import com.library.rest.repository.BookRepository;
import com.library.rest.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.empty();
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
