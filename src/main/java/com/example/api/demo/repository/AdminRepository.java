package com.example.api.demo.repository;

import com.example.api.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = """ 
            select * from admin where (:id is null or id=:id)
            """, nativeQuery = true)
    List<Admin> search(@Param("id") Integer id);

    @Modifying
    @Query(value = "insert into admin(name) values (:name)", nativeQuery = true)
    void create2(@Param("name") String name);

    @Modifying
    @Query(value = "delete from admin where name=:name", nativeQuery = true)
    void delete(@Param("name") String name);

}
