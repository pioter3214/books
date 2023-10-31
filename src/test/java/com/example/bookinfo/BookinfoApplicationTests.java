package com.example.bookinfo;

import com.example.bookinfo.entity.Book;
import com.example.bookinfo.repo.BookRepo;
import com.example.bookinfo.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookinfoApplicationTests {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookService bookService = new BookService();

    @BeforeEach
    void beforeAll() {
        Book book1 = new Book("1234567890","Book1");
        Book book2 = new Book("0987654321","Book2");
        when(bookRepo.findAll()).thenReturn(Stream.of(book1,book2).toList());
    }

    @Test
    @DisplayName("Should be Book1")
    void shouldBeBook1() {
        assertEquals("Book1",bookService.getBooks().get(0).getTitle());
    }

    @Test
    @DisplayName("Should be 0987654321")
    void shouldBe0987654321() {
        assertEquals("0987654321",bookService.getBooks().get(1).getIsbn());
    }
}
