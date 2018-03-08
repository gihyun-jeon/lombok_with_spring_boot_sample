package com.example.lombok_with_spring_boot_sample.book;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Wither
@Builder
@Value
public class BookMk6 {
    String isbn;

    String title;

    String author;

    int page;
}
