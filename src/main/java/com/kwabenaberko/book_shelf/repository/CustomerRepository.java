package com.kwabenaberko.book_shelf.repository;

import com.kwabenaberko.book_shelf.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
