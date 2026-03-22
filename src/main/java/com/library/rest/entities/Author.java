package com.library.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_day")
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    @Column(name = "literary_movement")
    private LiteraryMovement literaryMovement;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;
}
