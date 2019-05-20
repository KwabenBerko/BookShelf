package com.kwabenaberko.book_shelf.controller;

import com.kwabenaberko.book_shelf.config.CurrentUser;
import com.kwabenaberko.book_shelf.model.Customer;
import com.kwabenaberko.book_shelf.model.User;
import com.kwabenaberko.book_shelf.service.CustomerService;
import com.kwabenaberko.book_shelf.dto.CreateCustomerDTO;
import com.kwabenaberko.book_shelf.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    private ModelMapper modelMapper;

    @Autowired
    public CustomerController(CustomerService customerService, ModelMapper modelMapper){
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public CustomerDTO createAccount(@RequestBody CreateCustomerDTO dto){
        Customer customer = customerService.add(dto);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @PostMapping("/me")
    public CustomerDTO getProfile(@CurrentUser User user){
        Customer customer = customerService.findByUser(user);
        return modelMapper.map(customer, CustomerDTO.class);
    }
}
