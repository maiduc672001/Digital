package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  courseid;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "shortdescription")
    private String shortdescription;
    @OneToMany(mappedBy = "courseEntity")
    private List<QuestionEntity> questionEntities;
    @Column(name = "time")
    private Integer time;
    @OneToMany(mappedBy = "courseEntity")
    private List<ResultEntity> resultEntities;
}
