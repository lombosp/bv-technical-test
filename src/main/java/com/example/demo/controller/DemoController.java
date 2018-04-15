package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
	
	private Environment env;
	
	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}

	@RequestMapping("/status")
	public String status() {
		LOGGER.info("Get status");
		return "OK";
	}
	
	@RequestMapping("/version")
	public String version() {
		LOGGER.info("Get version");
		return env.getProperty("version.number");
	}
	
	
	
	

	
}
