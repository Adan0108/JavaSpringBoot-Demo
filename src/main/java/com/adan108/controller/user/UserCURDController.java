package com.adan108.controller.user;

import com.adan108.entity.user.UserEntity;
import com.adan108.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCURDController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        System.out.println("Received: " + userEntity);
        return userService.createUser(userEntity);
    }


    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String name,@RequestParam String email){
        return userService.findByUserNameAndUserEmail(name,email);
    }
}
