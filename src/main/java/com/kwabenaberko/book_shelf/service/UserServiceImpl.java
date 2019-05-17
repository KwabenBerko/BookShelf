package com.kwabenaberko.book_shelf.service;

import com.kwabenaberko.book_shelf.config.JwtTokenProvider;
import com.kwabenaberko.book_shelf.dto.AuthDTO;
import com.kwabenaberko.book_shelf.model.User;
import com.kwabenaberko.book_shelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByEmail(username);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("User not found.");
        }

        return user.get();
    }

    @Override
    @Transactional
    public User loadUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("User not found");
        }

        return user.get();
    }

}
