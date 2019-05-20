package com.kwabenaberko.book_shelf.service;

import com.kwabenaberko.book_shelf.dto.CreateBookDTO;
import com.kwabenaberko.book_shelf.model.Book;
import com.kwabenaberko.book_shelf.model.Customer;

import java.util.List;

public interface BookService {
    List<Book> findBooksFor(Customer customer);
    Book add(Customer customer, CreateBookDTO dto);
}
