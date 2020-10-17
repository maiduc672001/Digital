package com.example.demo.Convert;

import com.example.demo.DTO.ResultDTO;
import com.example.demo.Entity.ResultEntity;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultConvert {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    private ResultEntity dtoToEntity(ResultDTO dto){
        ResultEntity entity=new ResultEntity();
        modelMapper.map(dto,entity);
        entity.setUserEntity(userRepository.findByUsername(dto.getUserName()));
        entity.setCourseEntity(courseRepository.findByTitle(dto.getCourseName()));
        return entity;
    }
    private ResultDTO entityToDto(ResultEntity entity){
        ResultDTO dto=new ResultDTO();
        modelMapper.map(entity,dto);
        dto.setCourseName(entity.getCourseEntity().getTitle());
        dto.setUserName(entity.getUserEntity().getUsername());
        return dto;
    }
}
