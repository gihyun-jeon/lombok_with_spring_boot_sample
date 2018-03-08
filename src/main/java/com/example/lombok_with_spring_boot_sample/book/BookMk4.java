package com.example.lombok_with_spring_boot_sample.book;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BookMk4 {
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private String isbn;

    private String title;

    private String author;

    private int page;
}
