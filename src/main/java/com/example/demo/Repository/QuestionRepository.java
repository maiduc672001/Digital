package com.example.demo.Repository;

import com.example.demo.Entity.CourseEntity;
import com.example.demo.Entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
    QuestionEntity findByTitle(String title);
    List<QuestionEntity> getAllByCourseEntity(CourseEntity entity);
}
