package com.jiuyv.client;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jiuyv.util.R;

@Component
@FeignClient(value = "user-service")
public interface UserClient {
	
	@GetMapping("/user/user/countUser")
    int getUserCount();
	
}
