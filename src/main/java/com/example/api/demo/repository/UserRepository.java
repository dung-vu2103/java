package com.example.api.demo.repository;

import com.example.api.demo.dto.UserDto;
import com.example.api.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = """
            select * from user where (:id is null or id = :id)
            """, nativeQuery = true)
    List<User> search(@Param("id") Integer id);

    @Modifying
    @Query(value = "update user set name=:name, email=:email, pass=:pass where " +
            "id=:id ", nativeQuery = true)
    void update(@Param("id") Integer id, @Param("name") String name
            , @Param("email") String email, @Param("pass") String pass);

}
