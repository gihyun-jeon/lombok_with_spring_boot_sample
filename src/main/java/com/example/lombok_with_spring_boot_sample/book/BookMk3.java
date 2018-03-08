package com.example.lombok_with_spring_boot_sample.book;

import lombok.Data;

@Data
public class BookMk3 {
    private String isbn;

    private String title;

    private String author;

    private int page;
}
