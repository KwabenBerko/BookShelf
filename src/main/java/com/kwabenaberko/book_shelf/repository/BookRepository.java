package com.kwabenaberko.book_shelf.repository;

import com.kwabenaberko.book_shelf.model.Book;
import com.kwabenaberko.book_shelf.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCustomer(Customer customer);
}
