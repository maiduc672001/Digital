package com.example.demo.Convert;

import com.example.demo.DTO.CourseDTO;
import com.example.demo.Entity.CourseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseConvert {
    @Autowired
    private ModelMapper modelMapper;
    public CourseDTO entityToDto(CourseEntity entity){
        CourseDTO dto=new CourseDTO();
        modelMapper.map(entity,dto);
        return dto;
    }
    public CourseEntity dtoToEntity(CourseDTO dto){
        CourseEntity entity=new CourseEntity();
        modelMapper.map(dto,entity);
        return entity;
    }
}
