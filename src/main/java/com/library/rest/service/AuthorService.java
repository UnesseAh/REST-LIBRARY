package com.library.rest.service;

import com.library.rest.dto.author.AuthorRequest;
import com.library.rest.dto.author.AuthorResponse;
import com.library.rest.entities.enums.LiteraryMovement;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();
    AuthorResponse getAuthorById(Long id);
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    AuthorResponse updateAuthor(Long id, AuthorRequest authorRequest);
    void deleteAuthor(Long id);
    List<AuthorResponse> findByLiteraryMovement(LiteraryMovement movement);
}
