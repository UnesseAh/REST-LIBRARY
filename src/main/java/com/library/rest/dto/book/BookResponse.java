package com.library.rest.dto.book;

import com.library.rest.entities.enums.BookGenre;

public record BookResponse(
        Long id,
        String title,
        String isbn,
        Integer publishedYear,
        BookGenre bookGenre,
        String coverImageUrl,
        String authorName,
        Long authorId
) {
}
