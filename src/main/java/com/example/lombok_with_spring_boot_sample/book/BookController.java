package com.example.lombok_with_spring_boot_sample.book;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.acl.AclNotFoundException;
import java.util.NoSuchElementException;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RequestMapping(BookController.BASE_PATH)
@RestController
public class BookController {
    public static final String BASE_PATH = "/rest/v1/book/{isbn}";

    @Autowired
    private BookService bookService;


    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Void> insertBook(@PathVariable final String isbn, @RequestBody Book book) {
        Assert.isTrue(isbn.equals(book.getIsbn()), "isbn value must match.");

        bookService.insertBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Book> selectBook(@PathVariable final String isbn) {
        return bookService.selectBook(isbn)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseThrow(() -> new NoSuchElementException());
    }


    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<Void> updateBook(@PathVariable final String isbn, @RequestBody Book book) {
        Assert.isTrue(isbn.equals(book.getIsbn()), "isbn value must match.");

        bookService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBook(@PathVariable final String isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ExceptionHandler(Exception.class)
    private void handleException(Exception e, HttpServletResponse response) {
        response.setStatus(findMatchedHttpStatus(e).value());
    }


    private HttpStatus findMatchedHttpStatus(Exception e) {
        if (e instanceof NoSuchElementException) {
            return HttpStatus.NOT_FOUND;

        } else if (e instanceof MissingServletRequestParameterException
                || e instanceof TypeMismatchException
                || e instanceof IllegalArgumentException
                || e instanceof MethodArgumentNotValidException) {
            return HttpStatus.BAD_REQUEST;

        } else if (e instanceof AclNotFoundException) {
            return HttpStatus.FORBIDDEN;

        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
