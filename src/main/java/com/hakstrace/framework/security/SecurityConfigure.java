package com.hakstrace.framework.security;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Controller
public class SecurityConfigure extends WebMvcConfigurerAdapter {

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		return "hakstrace/login";
	}
	
	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

	@Bean
	public AuthenticationSecurity authenticationSecurity() {
		return new AuthenticationSecurity();
	}

	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private SecurityProperties security;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin()
					.loginPage("/login").failureUrl("/login?error").permitAll();
		}
		
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/plugins/**"); // #3
		}
	}

	@Order(Ordered.HIGHEST_PRECEDENCE + 10)
	protected static class AuthenticationSecurity extends
			GlobalAuthenticationConfigurerAdapter {

		@Autowired
		private DataSource dataSource;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(this.dataSource).withUser("admin")
					.password("admin").roles("ADMIN", "USER").and().withUser("user")
					.password("user").roles("USER");
		}
	}

}
