package com.kwabenaberko.rest_api_auth.user;

import com.kwabenaberko.rest_api_auth.account.Account;
import com.kwabenaberko.rest_api_auth.user.dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User add(CreateUserDTO dto) {
        Account account = new Account.Builder(dto.getEmail(), passwordEncoder.encode(dto.getPassword()))
                .withFirstName(dto.getFirstName())
                .withLastName(dto.getLastName())
                .build();
        return new User(account);
    }
}
