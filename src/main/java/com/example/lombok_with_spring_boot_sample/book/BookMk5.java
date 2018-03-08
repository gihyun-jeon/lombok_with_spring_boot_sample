package com.example.lombok_with_spring_boot_sample.book;

import lombok.Value;

@Value
public class BookMk5 {
    String isbn;

    String title;

    String author;

    int page;
}
