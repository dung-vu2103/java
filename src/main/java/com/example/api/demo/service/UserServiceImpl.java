package com.example.api.demo.service;

import com.example.api.demo.dto.BookDto;
import com.example.api.demo.dto.UserDto;
import com.example.api.demo.dto.User_CourseDto;
import com.example.api.demo.model.Book;
import com.example.api.demo.model.User;
import com.example.api.demo.model.User_Course;
import com.example.api.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> getUser(Integer id) {
        return repository.search(id);
    }

    @Override
    public void save(User users) {
        repository.save(users);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void up(Integer id, String name, String phone, String pass) {
        repository.update(id, name, phone, pass);
    }

    @Override
    public List<UserDto> getUserDto(Integer id) {
        List<User> users = repository.search(id);
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user.getId(), user.getName(),
                    user.getEmail(), user.getPass(), getBook(user.getBook()), get(user.getUser_course()));
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    private List<BookDto> getBook(List<Book> bookList) {
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : bookList) {

            bookDtoList.add(new BookDto(book.getId(), book.getName()));
        }
        return bookDtoList;
    }

    private List<User_CourseDto> get(List<User_Course> list) {
        List<User_CourseDto> userCourseDtos = new ArrayList<>();
        for (User_Course userCourse : list) {
            userCourseDtos.add(new User_CourseDto(userCourse.getUser_id(), userCourse.getCourse_id()));
        }
        return userCourseDtos;
    }
}
