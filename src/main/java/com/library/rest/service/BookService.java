package com.library.rest.service;

import com.library.rest.dto.book.BookRequest;
import com.library.rest.dto.book.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();
    BookResponse getBookById(Long id);
    BookResponse createBook(BookRequest bookRequest);
    BookResponse updateBook(Long id, BookRequest bookRequest);
    BookResponse patchBook(Long id, BookRequest bookRequest);
    void deleteBook(Long id);
}
