package com.library.rest.dto.author;

import com.library.rest.entities.enums.LiteraryMovement;
import java.time.LocalDate;

public record AuthorRequest(
        String fullName,
        LocalDate birthDay,
        LiteraryMovement literaryMovement
) {
}
