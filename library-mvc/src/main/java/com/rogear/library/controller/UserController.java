package com.rogear.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rogear.library.common.pojo.EUDataGridResult;
import com.rogear.library.pojo.User;
import com.rogear.library.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rogear on 2020/4/21
 **/
@RestController
@RequestMapping("user")
public class UserController {

    private Logger LOGGER = Logger.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/selectById")
    public String selectById(@RequestParam int id){
        LOGGER.info("selectById,id : "+ id);
        return userService.selectById(id).toString();
    }

    @GetMapping("/selectByUsername")
    public String selectByUsername(@RequestBody User user){
        List<User> userList = userService.selectByExample(user);
        return userList.toString();
    }

    @GetMapping("/selectByPage")
    public EUDataGridResult selectByPage(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                         @RequestParam(name = "size",defaultValue = "20") Integer size,
                                         @RequestParam(name = "username",defaultValue = "") String username){
        EUDataGridResult result = userService.selectByPage(page,size,username);
        return result;
    }

    @PostMapping(value = "/insert",consumes = "application/x-www-form-urlencoded")
    public String insert(User user){
        int insert = userService.insert(user);
        return String.valueOf(insert);
    }

//    @PostMapping(value = "/deleteById",consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.POST)
    public String deleteById(@PathVariable int id){
        int i = userService.deleteByPrimaryKey(id);
        return String.valueOf(i);
    }

    @PostMapping(value = "/update",consumes = "application/x-www-form-urlencoded")
    public String update( User user){
        int i = userService.updateByPrimaryKey(user);
        return String.valueOf(i);
    }
}
