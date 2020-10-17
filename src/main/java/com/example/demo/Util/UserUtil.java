package com.example.demo.Util;

import com.example.demo.security.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {
    public static UserPrincipal getUserPrincipal(){
        UserPrincipal userPrincipal= (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipal;
    }
}