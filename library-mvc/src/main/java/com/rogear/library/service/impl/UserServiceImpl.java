package com.rogear.library.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rogear.library.common.pojo.EUDataGridResult;
import com.rogear.library.dao.UserMapper;
import com.rogear.library.pojo.User;
import com.rogear.library.pojo.UserExample;
import com.rogear.library.service.UserService;
import com.rogear.library.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<User> selectByExample(User user) {
        UserExample userExample = new UserExample();
        if (null != user.getUsername()){
            userExample.createCriteria().andUsernameLike(user.getUsername());
        }
        return userMapper.selectByExample(userExample);
    }

    @Override
    public EUDataGridResult selectByPage(Integer page, Integer size, String username) {
        UserExample userExample = new UserExample();
        if (!username.isEmpty()){
            userExample.createCriteria().andUsernameLike("%"+username+"%");
        }
        if (null != page && null != size){
            PageHelper.startPage(page,size);
        }
        List<User> userList = userMapper.selectByExample(userExample);
        PageInfo pageInfo = new PageInfo(userList);
        EUDataGridResult result = new EUDataGridResult();
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(userList);
        return result;
    }

    @Override
    public int insert(User user) {
        user.setId(null);
        user.setPassword(MD5Util.encode(user.getPassword()));
        user.setLastUpdateTime(new Date());
        return userMapper.insertSelective(user);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        user.setPassword(MD5Util.encode(user.getPassword()));
        user.setLastUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(user);
    }
}
