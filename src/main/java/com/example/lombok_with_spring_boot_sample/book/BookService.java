package com.example.lombok_with_spring_boot_sample.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    void insertBook(Book book) {
        selectBook(book.getIsbn()).ifPresent(b -> {
            throw new IllegalArgumentException("Already exist book! db value=" + b);
        });
        bookDAO.insertOrUpdateBook(book);
    }

    Optional<Book> selectBook(String isbn) {
        return bookDAO.selectBook(isbn);
    }

    void updateBook(Book book) {
        bookDAO.insertOrUpdateBook(book);
    }

    void deleteBook(String isbn) {
        bookDAO.deleteBook(isbn);
    }
}
