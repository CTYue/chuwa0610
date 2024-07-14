package com.jackpang.xhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.jackpang.xhs")
public class XhsApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(XhsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(XhsApplication.class);
	}
}
