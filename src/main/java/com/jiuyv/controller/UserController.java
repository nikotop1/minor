package com.jiuyv.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiuyv.entity.User;
import com.jiuyv.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	//@Autowired
    private UserService userService;
 
    @GetMapping("/getAllUser")
    public List<User> findAll(){
        return userService.findAllUser();
    }
 
    @PostMapping("/getUserByUserID/{userid}")
    public List<User> findUserByUserId(@PathVariable String userid){
        return userService.findUserByUserId(userid);
    }
 
    @PostMapping("/getUserByUsername/{username}")
    public List<User> findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }
 
    @PostMapping("/insertUser")
    public User insertUser(User user){
        return userService.insertUser(user);
    }
 
   
    
    @PostMapping("/updateUser")
    public int updateUser(User user){
        return userService.updateUser(user);
    }
 
    @DeleteMapping("/deleteUser")
    public int deleteUser(User user){
        return userService.deleteUser(user);
    }

}
