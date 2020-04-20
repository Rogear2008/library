package com.rogear.library.controller;

import com.alibaba.fastjson.JSON;
import com.rogear.library.pojo.User;
import com.rogear.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rogear on 2020/4/20
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/insert")
    public boolean insert(String userJson){
        User user = JSON.parseObject(userJson,User.class);
        int num = userService.insertUser(user);
        if (num > 0){
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("selectById")
    public String selectById(@PathVariable int id){
        return userService.selectById(id).toString();
    }
}
