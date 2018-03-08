package com.example.lombok_with_spring_boot_sample.book;

import com.example.lombok_with_spring_boot_sample.LombokWithSpringBootSampleApplicationTests;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest extends LombokWithSpringBootSampleApplicationTests {

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

    @Test
    public void test_mk6_Controller() {
        // given
        String given_isbn = "isbn_of_" + UUID.randomUUID().toString();
        BookMk6 given_Book = BookMk6.builder()
                .isbn(given_isbn)
                .title("title_of_" + UUID.randomUUID().toString())
                .author("author_of_" + UUID.randomUUID().toString())
                .page(new Random().nextInt(1000))
                .build();

        String url = UriComponentsBuilder.fromPath(BookControllerOnMk6.BASE_PATH)
                .build()
                .expand(given_isbn)
                .toUriString();

        // when 등록요쳥
        ResponseEntity<Void> postResponse = testRestTemplate.postForEntity(url, given_Book, Void.class);

        // then
        assertThat(postResponse.getStatusCode()).as("응답 예상값 201").isEqualTo(HttpStatus.CREATED);
    }

}