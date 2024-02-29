package com.example.api.demo.controller;

import com.example.api.demo.dto.BookDto;
import com.example.api.demo.dto.Response;
import com.example.api.demo.dto.UserDto;
import com.example.api.demo.model.Book;
import com.example.api.demo.model.User;
import com.example.api.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestParam(value = "id", required = false) Integer id) {
        List<UserDto> userDtoList = service.getUserDto(id);
        return ResponseEntity.ok().body(userDtoList);


    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User users) {
        service.save(users);
        return ResponseEntity.ok().body(new Response(200, "Success", null));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User users) {
        if (users.getId() == null) {
            return ResponseEntity.badRequest().body(new Response(400, "ID is not null", null));
        }
        service.save(users);
        return ResponseEntity.ok().body(new Response(200, "Success", null));
    }

    @PostMapping("/update1")
    public ResponseEntity<?> updateUser1(@RequestBody User users) {
        if (users.getId() == null) {
            return ResponseEntity.badRequest().body(new Response(400, "ID is not null", null));
        }
        service.up(users.getId(), users.getName(), users.getEmail(), users.getPass());
        return ResponseEntity.ok().body(new Response(200, "Success", null));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "id") Integer id) {
        service.delete(id);
        return ResponseEntity.ok().body(new Response(200, "Success", null));
    }
}
