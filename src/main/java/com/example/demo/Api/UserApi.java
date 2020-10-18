package com.example.demo.Api;

import com.example.demo.Convert.UserConvert;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Util.UserUtil;
import com.example.demo.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserApi {
    @Autowired
    private UserService userService;
    @Autowired
    private UserConvert userConvert;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/user")
    public UserDTO getUserDetails(){
        UserPrincipal principal= UserUtil.getUserPrincipal();
        UserDTO userDTO=userService.getUserByUsername(principal.getUsername());
        return userDTO;
    }
}
