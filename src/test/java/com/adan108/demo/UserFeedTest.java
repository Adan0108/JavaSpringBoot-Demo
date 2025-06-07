package com.adan108.demo;

import com.adan108.entity.feed.FeedEntity;
import com.adan108.entity.user.UserEntity;
import com.adan108.repository.FeedRepository;
import com.adan108.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserFeedTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest(){

        //1. New User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("Adan 108");
        user.setUserEmail("adan108@gmail.com");

        feed.setUser(user);
        feed.setTitle("Sample Title");
        feed.setDescription("Sample description");
        user.setFeedList(new ArrayList<>(List.of(feed)));


        userRepository.save(user);
        feedRepository.save(feed);

    }

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTestTwo(){

        //1. New User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("Adan Java");
        user.setUserEmail("adanJava@gmail.com");

        feed.setUser(user);
        feed.setTitle("Feed 02");
        feed.setDescription("Sample description Feed 02");
        user.setFeedList(new ArrayList<>(List.of(feed)));


        userRepository.save(user);
        feedRepository.save(feed);

    }

    @Test
    @Transactional
    void selectOneToManyTest(){
        UserEntity user = userRepository.findById(8L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeedList());
    }
}
