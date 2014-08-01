package com.hakstrace.framework.view;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Controller
public class ViewConfigure extends WebMvcConfigurerAdapter {

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		return "hakstrace/index";
	}
}
