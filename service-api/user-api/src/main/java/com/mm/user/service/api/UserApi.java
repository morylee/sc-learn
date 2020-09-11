package com.mm.user.service.api;

import com.mm.auth.center.config.OAuth2FeignAutoConfiguration;
import com.mm.user.service.hystrix.UserFeignHystrix;
import com.mm.user.service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mm-user-provider", configuration = OAuth2FeignAutoConfiguration.class, fallback = UserFeignHystrix.class)
@RequestMapping("/user")
public interface UserApi {

	@GetMapping("/get/uuid")
	User getByUuid(@RequestParam("uuid") String uuid);

	@GetMapping("/get/name")
	User getByName(@RequestParam("name") String name);

	@PostMapping("/save")
	void save(@RequestParam("name") String name, @RequestParam("nickname") String nickname, @RequestParam("logoPath") String logoPath, @RequestParam("password") String password);

	@PostMapping("/login")
	boolean loginValid(@RequestParam("name") String name, @RequestParam("password") String password);

}
