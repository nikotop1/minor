package com.jiuyv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiuyv.entity.User;
import com.jiuyv.service.UserService;
/**
 * 
 * @author 25319
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 查
	 * @param id
	 * @return
	 */
	@PostMapping("/getById")
	public User findById(@RequestParam(value = "id", required = true) String id) {
        return userService.findUserById(id);
    }
	
	/**
	 * 删
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteById")
	public int deleteById(@RequestParam(value = "id", required = true) String id) {
        return userService.deleteById(id);
    }
	
	/**
	 * 改
	 * @param user
	 * @return
	 */
    @PostMapping("/updateById")
    public int updateById(@RequestBody User user) {
        return userService.updateById(user);
    }
    
    /**
     * 增
     * @param user
     * @return
     */
    @PostMapping("/createUser")
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    /**
     * 增
     * @param user
     * @return
     */
    @PostMapping("/createUserOne")
    public int createUserOne(@RequestBody User user) {
        return userService.createUserOne(user);
    }
    
    @GetMapping("/countUser")
    public int getUserCount() {
    	return userService.getUserCount();
    }
    
}
