package com.example.lombok_with_spring_boot_sample.book;

import org.junit.Test;

public class BookTest {

    @Test
    public void test_mk5() {
        //BookMk5 mk5 = new BookMk5();
        //mk5.setIsdn("i");

        BookMk5 mk5 = new BookMk5("i", "t", "a", 1);
    }

    @Test
    public void test_mk6() {
        BookMk6 mk6 = BookMk6.builder()
                .isbn("i")
                .title("t")
                .author("a")
                .page(10)
                .build();
        BookMk6 mk6_mod = mk6.withAuthor("mod_auther");
    }

}