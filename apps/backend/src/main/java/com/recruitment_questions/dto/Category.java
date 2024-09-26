package com.recruitment_questions.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    DESIGN_PATTERNS("Design patterns"),
    JAVA_LANGUAGE("Java language"),
    GENERAL("General"),
    JAVA_SOFTWARE("Java software"),
    SPRING("Spring");

    private final String text;

    Category(String text) {
        this.text = text;
    }

    @JsonCreator
    public static Category fromJsonText(String text) {
        for (Category category : Category.values()) {
            if (category.text.equalsIgnoreCase(text)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown category: " + text);
    }
}
