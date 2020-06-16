package com.jiuyv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiuyv.client.UserClient;
import com.jiuyv.service.TestClientService;
import com.jiuyv.util.R;

@RestController
@RequestMapping("/user")
public class TestClientController {
	@Autowired
    private TestClientService testClientService;

    @GetMapping("/countUser")
    public int getUser() {
    	
       return testClientService.countUser();
    }
}
