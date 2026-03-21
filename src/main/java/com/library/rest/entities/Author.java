package com.library.rest.entities;

import com.library.rest.entities.enums.LiteraryMovement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private LiteraryMovement literaryMovement;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
