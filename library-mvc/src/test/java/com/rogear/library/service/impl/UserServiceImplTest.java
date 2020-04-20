package com.rogear.library.service.impl;

import com.rogear.library.pojo.User;
import com.rogear.library.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context*.xml")
@Transactional
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void insertUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("abc");
        user.setPasswod("123");
        System.out.println(user.toString());
        userService.insertUser(user);
    }

    @Test
    void selectById() {
        User user = userService.selectById(1);
        System.out.println(user.toString());
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

}