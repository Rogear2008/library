package com.rogear.library.service.impl;

import com.rogear.library.dao.UserMapper;
import com.rogear.library.pojo.User;
import com.rogear.library.pojo.UserExample;
import com.rogear.library.service.LoginService;
import com.rogear.library.service.UserService;
import com.rogear.library.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Rogear on 2020/4/26
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpSession httpSession;

    @Override
    public boolean login(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(MD5Util.encode(user.getPassword()));

        System.out.println("username:"+user.getUsername()+" password:"+MD5Util.encode(user.getPassword()));
        List<User> users = userMapper.selectByExample(userExample);
        if (!users.isEmpty() && users.size() == 1){
            httpSession.setAttribute("currentUser",users.get(0));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean logOut() {
        httpSession.invalidate();
        return true;
    }
}
