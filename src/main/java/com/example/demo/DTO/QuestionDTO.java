package com.example.demo.DTO;

import lombok.Data;

@Data
public class QuestionDTO {
    private Long questionid;
    private String title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Integer answer;
    private String courseTitle;
    private Integer numberorder;
    private Integer youranswer;
}
