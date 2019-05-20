package com.kwabenaberko.book_shelf.service;

import com.kwabenaberko.book_shelf.dto.CreateBookDTO;
import com.kwabenaberko.book_shelf.model.Book;
import com.kwabenaberko.book_shelf.model.Customer;
import com.kwabenaberko.book_shelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findBooksFor(Customer customer) {
        return bookRepository.findByCustomer(customer);
    }

    @Override
    public Book add(Customer customer, CreateBookDTO dto) {
        Book book = new Book.Builder()
                .withTitle(dto.getTitle())
                .withAuthor(dto.getAuthor())
                .withIsbn(dto.getIsbn())
                .withCustomer(customer)
                .build();


        book.toString();
        Book createdBook = bookRepository.save(book);
        createdBook.toString();
        return createdBook;
    }
}
