package com.adan108.controller.user;

import com.adan108.entity.user.UserEntity;
import com.adan108.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/getAll")
    public Page<UserEntity> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(Sort.Direction.ASC, sort);
        Pageable pageable = PageRequest.of(page, size , sortBy);
        return userService.findAllUsers(pageable);
    }

    @GetMapping("/searchPage")
    public Page<UserEntity> searchPageUserName(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(Sort.Direction.ASC, sort);
        Pageable pageable = PageRequest.of(page, size , sortBy);
        return userService.findByUserName(name, pageable);
    }
}
