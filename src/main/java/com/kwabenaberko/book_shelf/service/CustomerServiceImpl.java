package com.kwabenaberko.book_shelf.service;

import com.kwabenaberko.book_shelf.model.User;
import com.kwabenaberko.book_shelf.model.Customer;
import com.kwabenaberko.book_shelf.repository.CustomerRepository;
import com.kwabenaberko.book_shelf.dto.CreateCustomerDTO;
import javassist.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private PasswordEncoder passwordEncoder;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder){
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Customer add(CreateCustomerDTO dto) {
        User user = new User.Builder(dto.getEmail(), passwordEncoder.encode(dto.getPassword()))
                .withFirstName(dto.getFirstName())
                .withLastName(dto.getLastName())
                .build();

        Customer customer = new Customer(user);
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {

        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()){
            throw new RuntimeException("Customer not found.");
        }
        return customer.get();
    }

    @Override
    public Customer findByUser(User user) {
        Optional<Customer> customer = customerRepository.findByUser(user);
        if(!customer.isPresent()){
            throw new RuntimeException("Customer not found.");
        }
        return customer.get();
    }
}
