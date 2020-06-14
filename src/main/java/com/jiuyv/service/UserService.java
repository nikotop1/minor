package com.jiuyv.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyv.dao.UserMapper;
import com.jiuyv.entity.User;

@Service
public class UserService {
	@Resource
   //@Autowired(required=false)
    //@Autowired
    private UserMapper userMapper;
 
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }
 
    public List<User> findUserByUserId(int userid){
        return userMapper.findUserByUserId(userid);
    }
 
    public List<User> findUserByUsername(String username){
        return userMapper.findUserByUsername(username);
    }
 
    public User insertUser(User user){
        userMapper.insertUser(user);
        return user;
    }
 
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
 
    public int deleteUser(User user){
        return userMapper.deleteUser(user);
    }
}


