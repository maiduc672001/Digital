package com.example.demo.Service;

import com.example.demo.Convert.QuestionConvert;
import com.example.demo.DTO.QuestionDTO;
import com.example.demo.DTO.ResultRequest;
import com.example.demo.Entity.CourseEntity;
import com.example.demo.Entity.QuestionEntity;
import com.example.demo.Entity.ResultEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.ResultRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Util.UserUtil;
import com.example.demo.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionConvert questionConvert;
    @Autowired
    private ResultRepository resultRepository;
    public List<QuestionDTO> getResult(List<ResultRequest> resultRequests, Long courseid){
        Integer grade=0;
        CourseEntity courseEntity=courseRepository.getOne(courseid);
        UserPrincipal userPrincipal= UserUtil.getUserPrincipal();
        UserEntity userEntity=userRepository.findByUsername(userPrincipal.getUsername());
        List<QuestionEntity> questionEntities=questionRepository.getAllByCourseEntity(courseEntity);
        List<QuestionDTO> questionDTOS=new ArrayList<>();
        for (QuestionEntity item:questionEntities) {
            for (ResultRequest item2:resultRequests) {
                if(item.getNumberorder()==item2.getNumberorder()){
                    if(item.getAnswer()==item2.getYouranswer()){
                        grade+=10;
                    }
                }
            }
        }
        for (QuestionEntity item:questionEntities) {
            QuestionDTO dto=questionConvert.entityToDto(item);
            questionDTOS.add(dto);
        }
        for (QuestionDTO item:questionDTOS) {
            for(ResultRequest item2:resultRequests){
                if(item.getNumberorder()==item2.getNumberorder()){
                    item.setYouranswer(item2.getYouranswer());
                }
            }
        }
        UserPrincipal principal= UserUtil.getUserPrincipal();
//        UserEntity user=userRepository.findByUsername(principal.getUsername());
        ResultEntity resultEntity=resultRepository.getByUserEntityAndCourseEntity(userEntity,courseEntity);
        if(resultEntity==null){
            resultEntity=new ResultEntity();
            resultEntity.setCourseEntity(courseEntity);
            resultEntity.setUserEntity(userEntity);
            resultEntity.setGrade(grade);
        }else {
            if (resultEntity.getGrade() < grade) {
                resultEntity.setGrade(grade);
            }
        }
        questionDTOS=questionDTOS.stream().sorted(Comparator.comparing(QuestionDTO::getNumberorder)).collect(Collectors.toList());
        resultRepository.save(resultEntity);
        return questionDTOS;
    }
}
