package com.sdf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoWebApplication extends SpringBootServletInitializer {

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(DemoWebApplication.class);
//	}

	public static void main(String[] args) {
		//禁用重启
//		System.setProperty("spring.devtools.restart.enabled","false");
//		SpringApplication.run(DemoWebApplication.class, args);
		SpringApplication app = new SpringApplication(DemoWebApplication.class);
		app.run(args);
	}

}
