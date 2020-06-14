package com.jiuyv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jiuyv.entity.User;
@Mapper
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
    
    public List<User> findAllUser();
    
    public List<User> findUserByUserId(int userid);
    
    public List<User> findUserByUsername(String username);
    
    public int insertUser(User user);
    
    public int updateUser(User user);
    
    public int deleteUser(User user);

}