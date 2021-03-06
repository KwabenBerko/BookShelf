package com.kwabenaberko.book_shelf.repository;

import com.kwabenaberko.book_shelf.model.Customer;
import com.kwabenaberko.book_shelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByUser(User user);
}
