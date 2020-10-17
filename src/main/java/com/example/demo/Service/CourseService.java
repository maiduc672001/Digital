package com.example.demo.Service;

import com.example.demo.Convert.CourseConvert;
import com.example.demo.DTO.CourseDTO;
import com.example.demo.Entity.CourseEntity;
import com.example.demo.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseConvert courseConvert;
    public List<CourseDTO> getList(){
        List<CourseDTO> list=new ArrayList<>();
        List<CourseEntity> courseEntityList=courseRepository.findAll();
        for (CourseEntity item:courseEntityList) {
            CourseDTO dto=courseConvert.entityToDto(item);
            list.add(dto);
        }
        return list;
    }
    public CourseDTO getOneCourse(Long courseid){
        CourseEntity entity=courseRepository.getOne(courseid);
        return courseConvert.entityToDto(entity);
    }
}
