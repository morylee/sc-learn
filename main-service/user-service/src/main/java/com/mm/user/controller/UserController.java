package com.mm.user.controller;

import com.mm.base.controller.BaseController;
import com.mm.base.config.Resources;
import com.mm.base.exception.ExistException;
import com.mm.base.exception.NotFoundException;
import com.mm.user.model.User;
import com.mm.user.feign.OauthFeignService;
import com.mm.user.service.UserService;
import com.mm.base.util.Map2ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author mory.lee
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private OauthFeignService oauthFeignService;

	/**
	 * 登录接口
	 * @param parameters
	 * @return
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	public Object login(@RequestParam Map<String, String> parameters) {
		parameters.put("client_id", "yzkx");
		parameters.put("client_secret", "123456q!");

		OAuth2AccessToken accessToken = oauthFeignService.oauthToken(parameters);
		return setSuccessModelMap(accessToken);
	}

	/**
	 * 根据uuid获取用户信息接口
	 * @param uuid
	 * @return
	 */
	@PreAuthorize("hasAuthority('m:user:show')")
	@GetMapping("/{uuid}")
	public Object getByUuid(@PathVariable("uuid") String uuid) {
		// TODO valid uuid
		User user = userService.load(new User(uuid, null));
		user.setPassword(null);

		return setSuccessModelMap(user);
	}

	/**
	 * 根据用户名获取用户信息
	 * @param name
	 * @return
	 */
	@PreAuthorize("hasAuthority('m:user:show')")
	@GetMapping("/")
	public Object getByName(@RequestParam("name") String name) {
		// TODO valid name
		User user = userService.load(new User(null, name));
		user.setPassword(null);

		return setSuccessModelMap(user);
	}

	/**
	 * 添加用户
	 * @param params
	 * @return
	 */
	@PreAuthorize("hasAuthority('m:user:add')")
	@PostMapping("/")
	public Object save(@RequestBody Map<String, Object> params) {
		User user = Map2ModelUtil.convert(User.class, params);
		// TODO valid user
		if (null != userService.load(new User(null, user.getName()))) {
			throw new ExistException(Resources.getMessage("DATA_EXISTS", Resources.getMessage("USER")));
		}
		user.preInsert();

		userService.save(user);

		return setSuccessModelMap(user.getUuid());
	}

	/**
	 * 注册接口
	 * @param params
	 * @return
	 */
	@PostMapping("/register")
	public Object register(@RequestBody Map<String, Object> params) {
		// TODO verify captcha
		return this.save(params);
	}

	/**
	 * 根据uuid更新用户
	 * @param uuid
	 * @param params
	 * @return
	 */
	@PreAuthorize("hasAuthority('m:user:update')")
	@PutMapping("/{uuid}")
	public Object update(@PathVariable("uuid") String uuid, @RequestBody Map<String, Object> params) {
		// TODO valid uuid
		User user = Map2ModelUtil.convert(User.class, params);
		// TODO valid user
		user.setUuid(uuid);
		userService.update(user);

		return setSuccessModelMap(user.getUuid());
	}

	/**
	 * 更新用户
	 * @param params
	 * @return
	 */
	@PutMapping("/")
	public Object update(@RequestBody Map<String, Object> params) {
		// TODO get curr uuid

		return this.update(null, params);
	}

	/**
	 * 根据uuid删除用户
	 * @param uuid
	 * @return
	 */
	@PreAuthorize("hasAuthority('m:user:delete')")
	@DeleteMapping("/{uuid}")
	public Object delete(@PathVariable("uuid") String uuid) {
		User user = userService.load(new User(uuid, null));
		if (user != null) {
			userService.delete(user);

			return setSuccessModelMap(true);
		} else {
			throw new NotFoundException(Resources.getMessage("DATA_NOT_FOUND", Resources.getMessage("USER")));
		}
	}

}
