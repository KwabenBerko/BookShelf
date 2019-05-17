package com.kwabenaberko.book_shelf.service;

import com.kwabenaberko.book_shelf.model.Customer;
import com.kwabenaberko.book_shelf.dto.CreateCustomerDTO;

public interface CustomerService {
    Customer add(CreateCustomerDTO dto);
    Customer findById(String id);
}
