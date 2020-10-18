package com.example.demo.Service;

import com.example.demo.Convert.UserConvert;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.RoleEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvert userConvert;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserDTO getUserByUsername(String name){
        UserEntity entity=userRepository.findByUsername(name);
        return userConvert.entityToDto(entity);
    }

    public UserEntity save(UserDTO dto){
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        UserEntity entity=userConvert.dtoToEntity(dto);
        RoleEntity roleEntity=roleRepository.getOne((long)2);
        entity.setRoleEntity(roleEntity);
        userRepository.save(entity);
        return entity;
    }
}
