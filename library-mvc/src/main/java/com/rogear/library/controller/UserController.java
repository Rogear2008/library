package com.rogear.library.controller;

import com.rogear.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rogear on 2020/4/21
 **/
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("selectById")
    public String selectById(@RequestParam int id){
        return userService.selectById(id).toString();
    }
}
