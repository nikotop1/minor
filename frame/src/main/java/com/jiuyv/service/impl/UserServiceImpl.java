package com.jiuyv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyv.dao.UserMapper;
import com.jiuyv.entity.User;
import com.jiuyv.service.UserService;

/**
 * 
 * @author 25319
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper usermapper;

	/**
	 * 
	 */
	@Override
	public User findUserById(String id) {

		return usermapper.selectByPrimaryKey(id);

	}

	/**
	 * 
	 */
	@Override
	public int deleteById(String id) {

		return usermapper.deleteByPrimaryKey(id);
	}

	/**
	 * 
	 */
	@Override
	public int updateById(User user) {
		return usermapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 
	 */
	@Override
	public int createUser(User user) {

		return usermapper.insertSelective(user);
	}

}
