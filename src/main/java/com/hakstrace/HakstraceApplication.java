package com.hakstrace;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class HakstraceApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(HakstraceApplication.class).run(args);
	}

	@Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
        		new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

}
