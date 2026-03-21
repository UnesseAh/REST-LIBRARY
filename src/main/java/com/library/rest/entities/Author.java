package com.library.rest.entities;

import com.library.rest.entities.enums.LiteraryMovement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, length = 100)
    private String fullName;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    @Column(name = "literary_movement")
    private LiteraryMovement literaryMovement;
}
