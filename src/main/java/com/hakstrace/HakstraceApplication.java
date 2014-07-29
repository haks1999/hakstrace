package com.hakstrace;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class HakstraceApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(HakstraceApplication.class).run(args);
	}


}
