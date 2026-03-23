package com.library.rest.service.impl;

import com.library.rest.dto.author.AuthorRequest;
import com.library.rest.dto.author.AuthorResponse;
import com.library.rest.entities.Author;
import com.library.rest.entities.enums.LiteraryMovement;
import com.library.rest.repository.AuthorRepository;
import com.library.rest.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        Author foundAuthor = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found with id : " + id));
        return mapToResponse(foundAuthor);
    }

    @Override
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setFullName(authorRequest.fullName());
        author.setBirthDay(authorRequest.birthDay());
        author.setLiteraryMovement(authorRequest.literaryMovement());

        Author savedAuthor = authorRepository.save(author);
        return mapToResponse(savedAuthor);
    }

    @Override
    public AuthorResponse updateAuthor(Long id, AuthorRequest authorRequest) {
        Author author = authorRepository.findById(id)
                .map(existingAuthor -> {
                    existingAuthor.setFullName(authorRequest.fullName());
                    existingAuthor.setBirthDay(authorRequest.birthDay());
                    existingAuthor.setLiteraryMovement(authorRequest.literaryMovement());
                    return authorRepository.save(existingAuthor);
                })
                .orElseThrow(() -> new RuntimeException("Author not found with id : " + id));
        return mapToResponse(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        if (authorRepository.existsById(id)){
            authorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete: Author not found with id : " + id);
        }
    }

    @Override
    public List<AuthorResponse> findByLiteraryMovement(LiteraryMovement movement) {
        return authorRepository.findByLiteraryMovement(movement).stream().map((this::mapToResponse)).toList();
    }

    private AuthorResponse mapToResponse(Author author){
        return new AuthorResponse(
                author.getId(),
                author.getFullName(),
                author.getBirthDay(),
                author.getLiteraryMovement(),
                author.getCreatedAt()
        );
    }
}
