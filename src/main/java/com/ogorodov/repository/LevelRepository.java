package com.ogorodov.repository;

import com.ogorodov.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LevelRepository extends JpaRepository<Level, Integer> {
   /* @Query("select l from Level l, User u where u.accesslevel.id = l.id and u.id = :id")
    String findLevel(@Param("id") Integer id);*/
}
