package com.kwabenaberko.rest_api_auth.user;

import com.kwabenaberko.rest_api_auth.user.dto.CreateUserDTO;

public interface UserService {
    User add(CreateUserDTO dto);
}
