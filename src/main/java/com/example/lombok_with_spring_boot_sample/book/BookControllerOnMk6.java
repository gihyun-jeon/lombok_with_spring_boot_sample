package com.example.lombok_with_spring_boot_sample.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RequestMapping(BookControllerOnMk6.BASE_PATH)
@RestController
public class BookControllerOnMk6 {
    public static final String BASE_PATH = "/rest/v1/bookMk6/{isbn}";

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Void> insertBook(@PathVariable final String isbn, @RequestBody BookMk6 book) {
        System.out.println(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
