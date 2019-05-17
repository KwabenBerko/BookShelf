package com.kwabenaberko.book_shelf.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class AuthDTO {
    @Email
    private String email;

    @Min(6)
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
