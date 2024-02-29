package com.example.api.demo.service;

import com.example.api.demo.dto.AdminDto;
import com.example.api.demo.model.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<Admin> getAdmin(Integer id);

    List<Admin> getAdmin(Integer id, String name);

    void save(Admin admin);

    void delete(Integer id);

    void save2(Admin admin);

    void save3(String name);

    void delete2(String name);

    List<AdminDto> getAdminDto(Integer id);

    List<Map<String, Object>> get2(Integer id);
}
