package com.library.rest.entities;

import com.library.rest.entities.enums.BookGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String isbn;
    private String title;
    private Integer publishedYear;
    @Enumerated(EnumType.STRING)
    @Column(name = "book_genre")
    private BookGenre bookGenre;
    private String coverImageUrl;
}
