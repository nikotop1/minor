package com.jiuyv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	 * 与不用@Transactional做对比
	 */
	@Override
	public int createUser(User user) {
		User user1 = user;
		int i = usermapper.insertSelective(user);

		int j = 0 / 0;

		int k = usermapper.insertSelective(user1);

		return i + k;
	}

	/**
	 * 测试用@Transactional 进行事务回滚
	 */
	@Override
	@Transactional
	public int createUserOne(User user) {
		User user1 = user;
		int i = usermapper.insertSelective(user);

		int j = 0 / 0;

		int k = usermapper.insertSelective(user1);

		return i + k;
	}

	@Override
	public int getUserCount() {
		return usermapper.countUser();
	}

}
