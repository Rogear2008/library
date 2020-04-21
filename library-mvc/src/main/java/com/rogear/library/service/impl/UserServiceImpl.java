package com.rogear.library.service.impl;

import com.rogear.library.dao.UserMapper;
import com.rogear.library.pojo.User;
import com.rogear.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rogear on 2020/4/21
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
