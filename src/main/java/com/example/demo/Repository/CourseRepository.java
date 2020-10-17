package com.example.demo.Repository;

import com.example.demo.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    CourseEntity findByTitle(String title);
}
