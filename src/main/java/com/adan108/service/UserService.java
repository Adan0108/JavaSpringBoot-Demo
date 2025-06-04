package com.adan108.service;

import com.adan108.entity.user.UserEntity;


import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
    List<UserEntity> findAllUsers();
}
