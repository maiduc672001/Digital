package com.example.demo.Repository;

import com.example.demo.Entity.CourseEntity;
import com.example.demo.Entity.ResultEntity;
import com.example.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<ResultEntity,Long> {
    ResultEntity getByUserEntityAndCourseEntity(UserEntity userEntity, CourseEntity courseEntity);
}
