package com.rogear.library.service;

import com.rogear.library.common.pojo.EUDataGridResult;
import com.rogear.library.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Rogear on 2020/4/21
 **/
public interface UserService {

    User selectById(int id);

    List<User> selectByExample(User user);

    EUDataGridResult selectByPage(int page, int size, String username);

    int insert(User user);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(User user);

}
