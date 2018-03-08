package com.example.lombok_with_spring_boot_sample.book;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookDAO {
    private static Map<String, Book> MAP_LIKE_DATA_BASE = new HashMap<>();

    void insertOrUpdateBook(Book book) {
        MAP_LIKE_DATA_BASE.put(book.getIsbn(), book);
    }

    Optional<Book> selectBook(String isbn) {
        return Optional.ofNullable(MAP_LIKE_DATA_BASE.get(isbn));
    }

    void deleteBook(String isbn) {
        MAP_LIKE_DATA_BASE.remove(isbn);
    }
}
