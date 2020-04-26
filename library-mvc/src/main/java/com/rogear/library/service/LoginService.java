package com.rogear.library.service;

import com.rogear.library.pojo.User;

/**
 * Created by Rogear on 2020/4/26
 **/
public interface LoginService {

    boolean login(User user);

    boolean logOut();
}
