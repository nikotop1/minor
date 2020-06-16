package com.jiuyv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyv.client.UserClient;
import com.jiuyv.service.TestClientService;
@Service
public class TestClientServiceImpl implements TestClientService{
@Autowired
private UserClient userClient;
	@Override
	public int countUser() {
		
		return userClient.getUserCount();
	}

}
