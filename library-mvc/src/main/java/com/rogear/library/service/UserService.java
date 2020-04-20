package com.rogear.library.service;

import com.rogear.library.pojo.User;

/**
 * Created by Rogear on 2020/4/20
 **/
public interface UserService {

    int insertUser(User user);

    User selectById(int id);

    int update(User user);

    int deleteById(User user);
}
