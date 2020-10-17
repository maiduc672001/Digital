package com.example.demo.Convert;

import com.example.demo.DTO.QuestionDTO;
import com.example.demo.Entity.QuestionEntity;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionConvert {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseRepository courseRepository;
    public QuestionDTO entityToDto(QuestionEntity entity){
        QuestionDTO dto=new QuestionDTO();
        modelMapper.map(entity,dto);
        dto.setCourseTitle(entity.getCourseEntity().getTitle());
        return dto;
    }
    public QuestionEntity dtoToEntity(QuestionDTO dto){
        QuestionEntity entity=new QuestionEntity();
        modelMapper.map(dto,entity);
        entity.setCourseEntity(courseRepository.findByTitle(dto.getCourseTitle()));
        return entity;
    }
}
