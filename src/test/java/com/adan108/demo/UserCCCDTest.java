package com.adan108.demo;

import com.adan108.entity.user.CCCDEntity;
import com.adan108.entity.user.UserEntity;
import com.adan108.repository.CCCDRepository;
import com.adan108.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class UserCCCDTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest(){
        UserEntity user = new UserEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserName("Adan CCCD");
        user.setUserEmail("cccd02@gmail.com");

        cccd.setNumberCCCD("1111112222233");
        user.setCccd(cccd);

        userRepository.save(user);
    }
}
