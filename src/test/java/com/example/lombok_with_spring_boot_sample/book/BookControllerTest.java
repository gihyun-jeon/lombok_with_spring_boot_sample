package com.example.lombok_with_spring_boot_sample.book;

import com.example.lombok_with_spring_boot_sample.LombokWithSpringBootSampleApplicationTests;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BookControllerTest extends LombokWithSpringBootSampleApplicationTests {

    @Test
    public void test_crud() {
        // given
        String given_isbn = "isbn_of_" + UUID.randomUUID().toString();
        Book given_Book = Book.builder()
                .isbn(given_isbn)
                .title("title_of_" + UUID.randomUUID().toString())
                .author("author_of_" + UUID.randomUUID().toString())
                .page(new Random().nextInt(1000))
                .build();
        String url = UriComponentsBuilder.fromPath(BookController.BASE_PATH)
                .build()
                .expand(given_isbn)
                .toUriString();

        // when 등록요쳥
        ResponseEntity<Void> postResponse = testRestTemplate.postForEntity(url, given_Book, Void.class);

        // then
        assertThat(postResponse.getStatusCode()).as("응답 예상값 201").isEqualTo(HttpStatus.CREATED);

        // when 조회
        ResponseEntity<Book> getResponse = testRestTemplate.getForEntity(url, Book.class);

        // then
        assertThat(getResponse.getStatusCode()).as("응답 예상값 200").isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody()).as("생성 요청한 book 과 동일해야 함").isEqualTo(given_Book);

        // given
        Book given_Book_mod = given_Book.withTitle("수정된이름");
        assertThat(given_Book_mod == given_Book).as("wither 를 통해 생성한 Object 는 reference 가 달라야 함").isFalse();
        assertThat(given_Book_mod).as("wither 를 통해 생성한 Object 는 not Equal 이다.").isNotEqualTo(given_Book);
        assertThat(given_Book_mod.getIsbn()).as("wither 를 통해 생성한 Object 다른 값은 동일하게 유지해야 함").isEqualTo(given_Book.getIsbn());
        assertThat(given_Book_mod.getAuthor()).as("wither 를 통해 생성한 Object 다른 값은 동일하게 유지해야 함").isEqualTo(given_Book.getAuthor());
        assertThat(given_Book_mod.getPage()).as("wither 를 통해 생성한 Object 다른 값은 동일하게 유지해야 함").isEqualTo(given_Book.getPage());

        // when 수정
        testRestTemplate.put(url, given_Book_mod);

        // then 결과확인
        getResponse = testRestTemplate.getForEntity(url, Book.class);
        assertThat(getResponse.getBody()).as("최초 요청한 book 과 달라야 함").isNotEqualTo(given_Book);
        assertThat(getResponse.getBody()).as("수정 요청한 book 과 동일해야 함").isEqualTo(given_Book_mod);

        // when 삭제
        testRestTemplate.delete(url);

        // then
        getResponse = testRestTemplate.getForEntity(url, Book.class);
        assertThat(getResponse.getStatusCode()).as("조회되지 않아야 함").isEqualTo(HttpStatus.NOT_FOUND);
    }
}