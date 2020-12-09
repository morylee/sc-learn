package com.mm.auth.server.controller;

import com.mm.base.controller.BaseController;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author mory.lee
 */
@RestController
@RequestMapping("/oauth")
public class UserController extends BaseController {

	@GetMapping("/user")
	public Principal user(Principal user){
		return user;
	}

}
