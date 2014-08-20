package com.hakstrace.system.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hakstrace.common.code.util.StaticCommonCode;
import com.hakstrace.system.user.domain.Authority;
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
	public Page<User> retrieveUserList( @RequestParam(value = "userName", required = false, defaultValue="") String userName,
										@RequestParam(value = "pageNum", required = false, defaultValue="1") int pageNum) {
		return userService.findAll(pageNum, userName);
	}
	
	@RequestMapping(value="/system/users/edit/{userId}", method = RequestMethod.GET, consumes="!application/json")
	public String forwardToUserDetail( @PathVariable String userId,
									final ModelMap model) {
		model.addAttribute(userService.findByUserId(userId));
		model.addAttribute(StaticCommonCode.PAGE_TYPE.READ,true);
		model.addAttribute(StaticCommonCode.PAGE_TYPE.UPDATE,true);
		model.addAttribute(StaticCommonCode.PAGE_TYPE.DELETE,true);
		return "hakstrace/system/user/user_detail";
	}
	
	@RequestMapping(value="/system/users/edit/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public User saveUserDetail( @PathVariable String userId,
								@RequestBody User user) {
		user.setUserId(userId);
		userService.updateUserDetail(user);
		return user;
	}
	
	@RequestMapping(value="/system/users/add", method = RequestMethod.GET, consumes="!application/json")
	public String forwardToUserAdd(final ModelMap model) {
		User user = new User();
		user.setAuthority(new Authority());
		model.addAttribute("user", user);
		model.addAttribute(StaticCommonCode.PAGE_TYPE.CREATE,true);
		return "hakstrace/system/user/user_detail";
	}
	
	@RequestMapping(value="/system/users/add/dupcheck", method = RequestMethod.GET, consumes="application/json")
	@ResponseBody
	public ModelMap checkExistUser(final ModelMap model,
									@RequestParam(value = "userId", required = true) String userId) {
		model.addAttribute("exist", userService.findByUserId(userId) == null);
		return model;
	}
	
}
