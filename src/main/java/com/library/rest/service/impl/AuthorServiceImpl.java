package com.library.rest.service.impl;

import com.library.rest.entities.Author;
import com.library.rest.entities.enums.LiteraryMovement;
import com.library.rest.repository.AuthorRepository;
import com.library.rest.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findByMovement(LiteraryMovement movement) {
        return List.of();
    }
}
