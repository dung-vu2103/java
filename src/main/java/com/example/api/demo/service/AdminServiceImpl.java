package com.example.api.demo.service;

import com.example.api.demo.dto.AdminDto;
import com.example.api.demo.dto.Admin_CourseDto;
import com.example.api.demo.model.Admin;
import com.example.api.demo.model.Admin_Course;
import com.example.api.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;


    @Override
    public List<Admin> getAdmin(Integer id) {
        return adminRepository.search(id);
    }

    @Override
    public List<Admin> getAdmin(Integer id, String name) {
        return null;
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void save2(Admin admin) {

    }

    @Override
    public void save3(String name) {
        adminRepository.create2(name);
    }

    @Override
    public void delete2(String name) {
        adminRepository.delete(name);
    }

    @Override
    public List<AdminDto> getAdminDto(Integer id) {
        List<Admin> list = adminRepository.search(id);
        List<AdminDto> adminDtos = new ArrayList<>();
        for (Admin admin : list) {
            adminDtos.add(new AdminDto(admin.getId(), admin.getName(), get(admin.getAdminCourseList())));
        }
        return adminDtos;
    }

    @Override
    public List<Map<String, Object>> get2(Integer id) {
        List<AdminDto> adminDtos = getAdminDto(id);
        List<Map<String, Object>> list = new ArrayList<>();
        for (AdminDto adminDto : adminDtos) {
            Map<String, Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("id", adminDto.getId().toString());
            stringObjectMap.put("name", adminDto.getName());
            stringObjectMap.put("List Course", adminDto.getList());
            list.add(stringObjectMap);

        }
        return list;
    }

    private List<Admin_CourseDto> get(List<Admin_Course> list) {
        List<Admin_CourseDto> adminCourseDtos = new ArrayList<>();
        for (Admin_Course adminCourse : list) {
            adminCourseDtos.add(new Admin_CourseDto(adminCourse.getAdmin_id(), adminCourse.getCourse_id()));
        }
        return adminCourseDtos;
    }
}
