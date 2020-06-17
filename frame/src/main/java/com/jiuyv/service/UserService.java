package com.jiuyv.service;

import org.springframework.stereotype.Service;

import com.jiuyv.entity.User;

/**
 * 
 * @author 25319
 *
 */

public interface UserService {

	/**
	 * 按id查找user
	 * 
	 * @param id
	 * @return
	 */
	User findUserById(String id);
	
	/**
	 * 按id删除user
	 * @param id
	 * @return
	 */
    int deleteById(String id);
    
    /**
	 * 按id修改user
	 * @param id
	 * @return
	 */
    int updateById(User user);
    
    /**
     * 新增user
     * @param user
     * @return
     */
    int createUser(User user);

    int createUserOne(User user);
    
    
	int getUserCount();
}
