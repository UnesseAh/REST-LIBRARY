package com.library.rest.dto.author;

import com.library.rest.entities.enums.LiteraryMovement;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AuthorResponse(
        Long id,
        String fullName,
        LocalDate birthDay,
        LiteraryMovement literaryMovement,
        LocalDateTime createdAt
) {
}
