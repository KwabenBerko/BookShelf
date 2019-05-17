package com.kwabenaberko.book_shelf.service;

import com.kwabenaberko.book_shelf.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User loadUserById(long id);
}
