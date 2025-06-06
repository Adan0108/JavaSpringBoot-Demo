package com.adan108.service;

import com.adan108.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    //get all by limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);

    //get search by limit offset
    Page<UserEntity> findByUserName(String username, Pageable pageable);
}
