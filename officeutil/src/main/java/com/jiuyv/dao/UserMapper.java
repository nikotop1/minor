package com.jiuyv.dao;

import java.util.List;


import com.jiuyv.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
    
    public List<User> findAllUser();
    
    public List<User> findUserByUserId(String userid);
    
    public List<User> findUserByUsername(String username);
    
    public User insertUser(User user);
    
    public int updateUser(User user);
    
    public int deleteUser(User user);

}