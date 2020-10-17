package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionid;
    @Column(name = "title")
    private String title;
    @Column(name = "option1")
    private String option1;
    @Column(name = "option2")
    private String option2;
    @Column(name = "option3")
    private String option3;
    @Column(name = "option4")
    private String option4;
    @Column(name = "answer")
    private Integer answer;
    @ManyToOne
    @JoinColumn(name = "courseid")
    private CourseEntity courseEntity;
    @Column(name = "numberorder")
    private Integer numberorder;
}
