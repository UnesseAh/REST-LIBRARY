package com.library.rest.service.impl;

import com.library.rest.entities.Author;
import com.library.rest.entities.Book;
import com.library.rest.repository.BookRepository;
import com.library.rest.service.AuthorService;
import com.library.rest.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book>  getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {
        Long authorId  = book.getAuthor().getId();
        Author author = authorService.getAuthorById(authorId).orElseThrow(() -> new RuntimeException("Cannot create book : Author not found with id : " + authorId));
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setIsbn(book.getIsbn());
                    existingBook.setPublishedYear(book.getPublishedYear());

                    if (book.getAuthor() != null && book.getAuthor().getId() != null){
                        Long authorId = book.getAuthor().getId();
                        Author author = authorService.getAuthorById(authorId)
                                .orElseThrow(() -> new RuntimeException("Cannot update book : No author found with id : " + authorId));
                        existingBook.setAuthor(author);
                    }
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id : " + id));
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete : Book not found with id : " + id);
        }
    }
}
