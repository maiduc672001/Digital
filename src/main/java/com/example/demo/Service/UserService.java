package com.example.demo.Service;

import com.example.demo.Convert.UserConvert;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvert userConvert;
    public UserDTO getUserByUsername(String name){
        UserEntity entity=userRepository.findByUsername(name);
        return userConvert.entityToDto(entity);
    }
}
