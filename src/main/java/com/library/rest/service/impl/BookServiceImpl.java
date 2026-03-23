package com.library.rest.service.impl;

import com.library.rest.dto.book.BookRequest;
import com.library.rest.dto.book.BookResponse;
import com.library.rest.entities.Author;
import com.library.rest.entities.Book;
import com.library.rest.repository.AuthorRepository;
import com.library.rest.repository.BookRepository;
import com.library.rest.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookResponse>  getAllBooks() {
        return bookRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No book found with id : " + id));
        return mapToResponse(book);
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setIsbn(bookRequest.isbn());
        book.setPublishedYear(bookRequest.publishedYear());
        book.setBookGenre(bookRequest.bookGenre());
        book.setCoverImageUrl(bookRequest.coverImageUrl());

        Long authorId  = bookRequest.authorId();
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("No author found with id : " + authorId));
        book.setAuthor(author);
        Book savedBook = bookRepository.save(book);
        return mapToResponse(savedBook);
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest bookRequest) {
        Book book =  bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(bookRequest.title());
                    existingBook.setIsbn(bookRequest.isbn());
                    existingBook.setPublishedYear(bookRequest.publishedYear());

                    if (bookRequest.authorId() != null){
                        Long authorId = bookRequest.authorId();
                        Author author = authorRepository.findById(authorId)
                                .orElseThrow(() -> new RuntimeException("Cannot update book : No author found with id : " + authorId));
                        existingBook.setAuthor(author);
                    }
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id : " + id));
        return mapToResponse(book);
    }

    @Override
    public BookResponse patchBook(Long id, BookRequest bookRequest) {
        Book book =  bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id : " + id));

        if (bookRequest.title() != null){
            book.setTitle(bookRequest.title());
        }

        if (bookRequest.isbn() != null){
            book.setIsbn(bookRequest.isbn());
        }

        if (bookRequest.publishedYear() != null){
            book.setPublishedYear(bookRequest.publishedYear());
        }

        if (bookRequest.bookGenre() != null){
            book.setBookGenre(bookRequest.bookGenre());
        }

        if (bookRequest.coverImageUrl() != null){
            book.setCoverImageUrl(bookRequest.coverImageUrl());
        }

        if (bookRequest.authorId() != null){
            Author author = authorRepository.findById(bookRequest.authorId())
                    .orElseThrow(() -> new RuntimeException("Cannot update book: No author found with id : " + bookRequest.authorId()));
            book.setAuthor(author);
        }
        Book savedBook = bookRepository.save(book);
        return mapToResponse(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete : Book not found with id : " + id);
        }
    }

    private BookResponse mapToResponse(Book book){
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPublishedYear(),
                book.getBookGenre(),
                book.getCoverImageUrl(),
                book.getAuthor().getFullName(),
                book.getAuthor().getId()
        );
    }
}
