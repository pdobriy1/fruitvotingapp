package com.fruitvoting.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class DemoappApplication {

	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "running spring boot app";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoappApplication.class, args);
	}
}
