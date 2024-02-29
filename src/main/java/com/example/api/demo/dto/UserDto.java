package com.example.api.demo.dto;

import com.example.api.demo.model.Book;
import com.example.api.demo.model.User_Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String pass;
    private List<BookDto> book;
    private List<User_CourseDto> userCourseDtos;


}
