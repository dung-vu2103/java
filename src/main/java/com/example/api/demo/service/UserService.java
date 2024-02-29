package com.example.api.demo.service;

import com.example.api.demo.dto.UserDto;
import com.example.api.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUser(Integer id);

    void save(User users);

    void delete(Integer id);

    void up(Integer id, String name, String phone, String pass);

    List<UserDto> getUserDto(Integer id);
}
