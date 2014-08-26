package com.hakstrace.system.menu.controller;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hakstrace.framework.view.Layout;

@Configuration
@Controller
public class MenuController{

	@RequestMapping("/")
	@Layout("layouts/main_layout")
	public String index(Map<String, Object> model) {
		return "hakstrace/index";
	}
	
}
