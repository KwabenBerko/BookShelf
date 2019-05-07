package com.kwabenaberko.rest_api_auth.user;

import com.kwabenaberko.rest_api_auth.user.dto.CreateUserDTO;
import com.kwabenaberko.rest_api_auth.user.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("users")
    public UserDTO createAccount(@RequestBody CreateUserDTO dto){
        User user = userService.add(dto);
        user.setId(UUID.randomUUID().toString());
        return modelMapper.map(user, UserDTO.class);
    }
}
