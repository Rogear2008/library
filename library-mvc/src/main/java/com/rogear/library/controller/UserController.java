package com.rogear.library.controller;

import com.rogear.library.pojo.User;
import com.rogear.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/selectById")
    public String selectById(@RequestParam int id){
        return userService.selectById(id).toString();
    }

    @GetMapping("/selectByUsername")
    public String selectByUsername(@RequestBody User user){
        List<User> userList = userService.selectByExample(user);
        return userList.toString();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody User user){
        int insert = userService.insert(user);
        return String.valueOf(insert);
    }

    @PostMapping("/deleteById")
    public String deleteById(@RequestParam int id){
        int i = userService.deleteByPrimaryKey(id);
        return String.valueOf(i);
    }

    @DeleteMapping("/delete")
    public String update(@RequestBody User user){
        int i = userService.updateByPrimaryKey(user);
        return String.valueOf(i);
    }
}
