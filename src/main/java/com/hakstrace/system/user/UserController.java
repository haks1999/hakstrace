package com.hakstrace.system.user;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/system/users")
	public String forwardToUserList(Map<String, Object> model) {
		return "hakstrace/system/user/user_list";
	}
}
