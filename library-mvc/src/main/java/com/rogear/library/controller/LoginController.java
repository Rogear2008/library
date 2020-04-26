package com.rogear.library.controller;

import com.rogear.library.pojo.User;
import com.rogear.library.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rogear on 2020/4/26
 **/
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    private Logger LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user){
        LOGGER.info("登陆系统,User:"+user.toString());
        boolean result = loginService.login(user);
        if (result){
            return "redirect:/main.jsp";
        } else {
            return "redirect:/login.jsp";
        }
    }

    @ResponseBody
    @RequestMapping("/logOut")
    public String logOut(){
        boolean result = loginService.logOut();
        if (result){
            return "1";
        } else {
            return "0";
        }
    }
}
