package com.example.demo.Api;

import com.example.demo.DTO.CourseDTO;
import com.example.demo.DTO.QuestionDTO;
import com.example.demo.DTO.ResultRequest;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.QuestionService;
import com.example.demo.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseApi {
    @Autowired
    private CourseService courseService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ResultService resultService;
    @GetMapping("/course")
    private List<CourseDTO> getAllCourse(){
        return courseService.getList();
    }
    @GetMapping("/test/{courseid}")
    private List<QuestionDTO> getListQuestions(@PathVariable(value = "courseid")Long courseid){
        return questionService.getList(courseid);
    }
    @GetMapping("/course/{courseid}")
    private CourseDTO getOneCourse(@PathVariable(value = "courseid")Long courseid){
        return courseService.getOneCourse(courseid);
    }
    @PostMapping("/test/{courseid}")
    private List<QuestionDTO> getGrade(@PathVariable(value = "courseid")Long courseid, @RequestBody List<ResultRequest> resultRequests){
        return resultService.getResult(resultRequests,courseid);
    }
}
