package com.kwabenaberko.book_shelf.service;

import com.kwabenaberko.book_shelf.model.Customer;
import com.kwabenaberko.book_shelf.dto.CreateCustomerDTO;
import com.kwabenaberko.book_shelf.model.User;

public interface CustomerService {
    Customer add(CreateCustomerDTO dto);
    Customer findById(String id);
    Customer findByUser(User user);
}
