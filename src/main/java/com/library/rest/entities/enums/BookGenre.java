package com.library.rest.entities.enums;

import lombok.Getter;

@Getter
public enum BookGenre {
    FICTION("Fiction", "Stories created from the imagination."),
    NON_FICTION("Non-Fiction", "Informative and factual writing."),
    SCIENCE_FICTION("Sci-Fi", "Speculative technology, space, and futuristic concepts."),
    PHILOSOPHY("Philosophy", "Deep inquiries into existence, knowledge, and ethics."),
    MYSTERY("Mystery", "Plots involving a crime or a puzzle to be solved."),
    DYSTOPIAN("Dystopian", "Society characterized by human misery and oppression."),
    BIOGRAPHY("Biography", "An account of someone's life written by another."),
    FANTASY("Fantasy", "Magical elements and mythical creatures.");

    private final String displayName;
    private final String description;

    BookGenre(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
}
