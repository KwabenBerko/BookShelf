package com.kwabenaberko.rest_api_auth.book;

import com.kwabenaberko.rest_api_auth.book.dto.BookDTO;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {
    @GetMapping("/books")
    public Book findOneBook(){
        Book book = new Book.Builder()
                .withTitle("Effective Java")
                .withAuthor("Joshua Bloch")
                .withIsbn("978-0134685991")
                .build();

        return book;
    }

    @PostMapping("books")
    public BookDTO addBook(@RequestBody BookDTO dto){
        return dto;
    }
}
