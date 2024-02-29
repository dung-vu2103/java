package com.example.api.demo.controller;

import com.example.api.demo.dto.AdminDto;
import com.example.api.demo.dto.Response;
import com.example.api.demo.model.Admin;
import com.example.api.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping("/get")
    public ResponseEntity<?> getAdmin(@RequestParam(value = "id", required = false) Integer id) {
        List<Map<String, Object>> adminDtoMap = service.get2(id);
        return ResponseEntity.ok().body(adminDtoMap);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Admin admin) {
        service.save(admin);
        return ResponseEntity.ok().body(new Response(200, "Sucess", null));
    }

    @PostMapping("/create2")
    public ResponseEntity<?> create1(@RequestBody Admin admin) {
        service.save3(admin.getName());
        return ResponseEntity.ok().body(new Response(200, "Sucess", null));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Admin admin) {
        if (admin.getId() == null) {
            return ResponseEntity.badRequest().body(new Response(400, "Fail", null));
        }
        service.save(admin);
        return ResponseEntity.ok().body(new Response(200, "Sucess", null));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Integer id) {
        service.delete(id);
        return ResponseEntity.ok().body(new Response(200, "Sucess", null));
    }

    @DeleteMapping("/delete1")
    public ResponseEntity<?> delete1(@RequestParam(value = "name") String name) {
        service.delete2(name);
        return ResponseEntity.ok().body(new Response(200, "Sucess", null));
    }

}
