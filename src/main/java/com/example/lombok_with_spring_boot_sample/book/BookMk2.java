package com.example.lombok_with_spring_boot_sample.book;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class BookMk2 {
    @Getter
    @Setter
    private String isbn;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String author;

    @Getter
    @Setter
    private int page;
}
