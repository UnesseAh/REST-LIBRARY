package com.library.rest.controller;

import com.library.rest.dto.author.AuthorRequest;
import com.library.rest.dto.author.AuthorResponse;
import com.library.rest.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping()
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest){
        AuthorResponse createdAuthor =  authorService.createAuthor(authorRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAuthor.id())
                .toUri();
        return ResponseEntity.created(location).body(createdAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest authorRequest){
        return ResponseEntity.ok(authorService.updateAuthor(id, authorRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorResponse> patchAuthor(@PathVariable Long id, @RequestBody AuthorRequest authorRequest){
        return ResponseEntity.ok(authorService.patchAuthor(id, authorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
