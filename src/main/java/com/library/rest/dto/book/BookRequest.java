package com.library.rest.dto.book;

import com.library.rest.entities.enums.BookGenre;

public record BookRequest(
        String title,
        String isbn,
        Integer publishedYear,
        BookGenre bookGenre,
        String coverImageUrl,
        Long authorId
) {
}
