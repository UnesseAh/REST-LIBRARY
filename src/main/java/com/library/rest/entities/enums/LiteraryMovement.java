package com.library.rest.entities.enums;

import lombok.Getter;

@Getter
public enum LiteraryMovement {
    EXISTENTIALISM("Existentialism", "Focus on individual existence, freedom, and choice."),
    REALISM("Realism", "Depicting everyday life and society as they are."),
    ROMANTICISM("Romanticism", "Emphasis on emotion, nature, and individualism."),
    MODERNISM("Modernism", "A break from traditional ways of writing, exploring inner consciousness."),
    POST_MODERNISM("Post Modernism", "Playful, fragmented, and often skeptical of grand narratives."),
    SURREALISM("Surrealism", "Mixing dreams and reality to unlock the unconscious mind."),
    CLASSICISM("Classicism", "Following the formal styles of Ancient Greek and Roman literature."),
    MAGICAL_REALISM("Magical Realism", "Realistic narrative combined with surreal elements of dream or fantasy.");

    private final String displayName;
    private final String description;

    LiteraryMovement(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
}
