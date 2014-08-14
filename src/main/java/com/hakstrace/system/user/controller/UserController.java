package com.hakstrace.system.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hakstrace.system.user.domain.User;
import com.hakstrace.system.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/system/users", method = RequestMethod.GET, consumes="!application/json")
	public String forwardToUserList() {
		return "hakstrace/system/user/user_list";
	}
	
	@RequestMapping(value="/system/users", method = RequestMethod.GET, consumes="application/json")
	@ResponseBody
	public Page<User> retrieveUserList(
										@RequestParam(value = "userName", required = false, defaultValue="") String userName,
										@RequestParam(value = "pageNum", required = false, defaultValue="1") int pageNum) {
		return userService.findAll(pageNum, userName);
	}
	
	@RequestMapping(value="/system/users/{userId}", method = RequestMethod.GET, consumes="!application/json")
	public String forwardToUserDetail(@PathVariable String userId) {
		return "hakstrace/system/user/user_detail";
	}
}
