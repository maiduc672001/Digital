package com.example.demo.Service;

import com.example.demo.Convert.QuestionConvert;
import com.example.demo.DTO.CourseDTO;
import com.example.demo.DTO.QuestionDTO;
import com.example.demo.DTO.ResultRequest;
import com.example.demo.Entity.CourseEntity;
import com.example.demo.Entity.QuestionEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Util.UserUtil;
import com.example.demo.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionConvert questionConvert;
    @Autowired
    private CourseRepository courseRepository;

    public List<QuestionDTO> getList(Long courseid){
        CourseEntity entity=courseRepository.getOne(courseid);
        List<QuestionEntity> questionEntities=questionRepository.getAllByCourseEntity(entity);
        List<QuestionDTO> questionDTOS=new ArrayList<>();
        for (QuestionEntity item :questionEntities) {
            QuestionDTO dto=questionConvert.entityToDto(item);
            questionDTOS.add(dto);
        }
        return questionDTOS;
    }

}
