package com.hakstrace.framework.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
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

	/*
	@Bean
	public AuthenticationSecurity authenticationSecurity() {
		return new AuthenticationSecurity();
	}
	*/
	
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private SecurityProperties security;
		@Autowired
		private ApplicationContext context;
		
		@Override
		protected UserDetailsService userDetailsService() {
			return (UserDetailsService) context.getBean("userService");
	    }
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin().defaultSuccessUrl("/")
					.loginPage("/login").failureUrl("/login?error").permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		}
		
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/plugins/**","/img/**");
		}
		
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
		}
		
	}

	//@Order(Ordered.HIGHEST_PRECEDENCE + 10)
	/*
	protected static class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter {

		@Autowired
		private DataSource dataSource;
		//@Autowired
		//private MyUserDetailsService myUserDetailsService;

		@Bean
		protected UserDetailsService userDetailsService() {
			return new MyUserDetailsService();
	    }
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(this.dataSource).withUser("admin")
					.password("admin").roles("ADMIN", "USER").and().withUser("user")
					.password("user").roles("USER");
					
		}
		
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception{
			//PasswordEncoder encoder = new BCryptPasswordEncoder();
			//auth.userDetailsService(userDetailsService);//.passwordEncoder(encoder);
			//auth.userDetailsService(myUserDetailsService);//.and().jdbcAuthentication().dataSource(dataSource);
			auth.userDetailsService(this.userDetailsService());
		}
		
	}
	*/

}
