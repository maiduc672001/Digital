package com.example.demo.Api;

import com.example.demo.Convert.RoleConvert;
import com.example.demo.Convert.UserConvert;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Util.GoogleResponse;
import com.example.demo.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class LoginApi {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private UserConvert userConvert;
    @Autowired
    private RoleConvert roleConvert;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
    @PostMapping("signin/google")
    public ResponseEntity<?> loginGoogle(@RequestBody GoogleResponse googleResponse){
        if(googleResponse!=null) {
            UserEntity entity=userRepository.findByEmail(googleResponse.getEmail());
            UserPrincipal userPrincipal= UserPrincipal.create(entity);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userPrincipal,null,userPrincipal.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt=tokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
        }
        return new ResponseEntity(new UserResponse(false, "Error!"),
                HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/add/user")
    public ResponseEntity<?> addNewUser(@RequestBody UserDTO userDTO){
       UserEntity entity= userService.save(userDTO);
        UserPrincipal userPrincipal= UserPrincipal.create(entity);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userPrincipal,null,userPrincipal.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt=tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
}
