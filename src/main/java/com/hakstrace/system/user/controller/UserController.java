package com.hakstrace.system.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hakstrace.system.user.domain.User;
import com.hakstrace.system.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/system/users")
	public String forwardToUserList(Map<String, Object> model) {
		return "hakstrace/system/user/user_list";
	}
	
	@RequestMapping("/system/users/list")
	@ResponseBody
	public Page<User> retrieveUserList(
										@RequestParam(value = "userName", required = false, defaultValue="") String userName,
										@RequestParam(value = "pageNum", required = false, defaultValue="1") int pageNum) {
		return userService.findAll(pageNum, userName);
	}
}
