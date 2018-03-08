package com.example.lombok_with_spring_boot_sample.book;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@JsonDeserialize(builder = Book.BookBuilder.class)
@Builder
@Wither
@Value
public class Book {
    @SuppressWarnings("WeakerAccess")
    @JsonPOJOBuilder(withPrefix = "") // https://blog.d46.us/java-immutable-lombok/
    public static final class BookBuilder {
    }

    private final String isbn;

    private final String title;

    private final String author;

    private final int page;
}
