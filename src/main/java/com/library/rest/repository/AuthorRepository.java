package com.library.rest.repository;

import com.library.rest.entities.Author;
import com.library.rest.entities.enums.LiteraryMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByLiteraryMovement(LiteraryMovement movement);
}
