package com.example.demo.DTO;

import lombok.Data;

@Data
public class CourseDTO {
    private Long courseid;
    private String title;
    private String image;
    private String shortdescription;
    private Integer time;
}
