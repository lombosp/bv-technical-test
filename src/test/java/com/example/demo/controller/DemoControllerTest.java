package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DemoApplication.class })
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
public class DemoControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private Environment env;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
	    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testStatus() throws Exception {
		mockMvc.perform(get("/status"))
			.andExpect(status().isOk())
			.andExpect(content().string("OK"));
	}
	
	@Test
	public void testVersion() throws Exception {
		mockMvc.perform(get("/version"))
			.andExpect(status().isOk())
			.andExpect(content().string(env.getProperty("version.number")));
	}

}
