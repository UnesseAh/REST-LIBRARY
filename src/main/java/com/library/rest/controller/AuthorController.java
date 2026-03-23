package com.library.rest.controller;

import com.library.rest.dto.author.AuthorRequest;
import com.library.rest.dto.author.AuthorResponse;
import com.library.rest.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorResponse> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping()
    public AuthorResponse createAuthor(@RequestBody AuthorRequest authorRequest){
        return authorService.createAuthor(authorRequest);
    }

    @PutMapping("/{id}")
    public AuthorResponse updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest authorRequest){
        return authorService.updateAuthor(id, authorRequest);
    }

    @PatchMapping("/{id}")
    public AuthorResponse patchAuthor(@PathVariable Long id, @RequestBody AuthorRequest authorRequest){
        return authorService.patchAuthor(id, authorRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }
}
