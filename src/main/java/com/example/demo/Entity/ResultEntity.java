package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "result")
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultid;
    @Column(name = "grade")
    private Integer grade;
    @ManyToOne
    @JoinColumn(name = "courseid")
    private CourseEntity courseEntity;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;
}
