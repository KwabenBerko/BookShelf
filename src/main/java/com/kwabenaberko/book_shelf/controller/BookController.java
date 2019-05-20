package com.kwabenaberko.book_shelf.controller;

import com.kwabenaberko.book_shelf.config.CurrentUser;
import com.kwabenaberko.book_shelf.dto.CreateBookDTO;
import com.kwabenaberko.book_shelf.model.Book;
import com.kwabenaberko.book_shelf.model.Customer;
import com.kwabenaberko.book_shelf.model.User;
import com.kwabenaberko.book_shelf.service.BookService;
import com.kwabenaberko.book_shelf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private CustomerService customerService;

    @Autowired
    public BookController(BookService bookService, CustomerService customerService){
        this.bookService = bookService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Book> findAllBooks(@CurrentUser User user){
//        Book book = new Book.Builder()
//                .withTitle("Effective Java")
//                .withAuthor("Joshua Bloch")
//                .withIsbn("978-0134685991")
//                .build();
        Customer customer = customerService.findByUser(user);
        return bookService.findBooksFor(customer);
    }

    @PostMapping
    public Book addBook(@CurrentUser User user, @RequestBody CreateBookDTO dto){
        Customer customer = customerService.findByUser(user);
        return bookService.add(customer, dto);
    }
}
