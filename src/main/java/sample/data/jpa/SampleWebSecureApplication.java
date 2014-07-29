package sample.data.jpa;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@ComponentScan
public class SampleWebSecureApplication {

	@RequestMapping("/")

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(SampleWebSecureApplication.class).run(args);
	}


}
