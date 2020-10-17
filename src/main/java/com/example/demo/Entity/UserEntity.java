package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
@Column(name = "username")
    private String username;
@Column(name = "password")
    private String password;
@Column(name = "fullname")
private String fullname;
@ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEntity roleEntity;
@OneToMany(mappedBy = "userEntity")
    private List<ResultEntity> resultEntityList;
}
