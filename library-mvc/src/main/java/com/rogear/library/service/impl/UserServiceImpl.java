package com.rogear.library.service.impl;

import com.rogear.library.dao.UserMapper;
import com.rogear.library.pojo.User;
import com.rogear.library.pojo.UserExample;
import com.rogear.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rogear on 2020/4/20
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectById(int id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(id);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.isEmpty()){
            return null;
        } else {
            return userList.get(0);
        }
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int deleteById(User user) {
        return 0;
    }
}
