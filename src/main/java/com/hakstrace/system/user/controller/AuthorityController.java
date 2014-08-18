package com.hakstrace.system.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hakstrace.system.user.domain.Authority;
import com.hakstrace.system.user.service.AuthorityService;

@Controller
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value="/system/authorities", method = RequestMethod.GET, consumes="application/json")
	@ResponseBody
	public List<Authority> retrieveAuthorityList() {
		return authorityService.findAll();
	}
	
}
