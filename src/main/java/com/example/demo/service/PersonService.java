package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.DemoController;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
	
	private PersonRepository repository;
	
	@Autowired
	public void setRepository(PersonRepository repository) {
		this.repository = repository;
	}
	
	
	public void save(Person person) {
		LOGGER.info("Save person");
		repository.save(person);
	}

}
