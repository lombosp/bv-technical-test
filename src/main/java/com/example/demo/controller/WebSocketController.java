package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Message;
import com.example.demo.model.Person;
import com.example.demo.model.PersonDTO;
import com.example.demo.service.PersonService;

@Controller
public class WebSocketController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketController.class);
	
	private PersonService service;
	
	@Autowired
	public void setService(PersonService service) {
		this.service = service;
	}

    @MessageMapping("/insert")
    @SendTo("/message/actions")
    public Message greeting(PersonDTO personDTO) throws Exception {
    	LOGGER.info("Insert new person");
        Person person = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getAge());
        service.save(person);
        LOGGER.info("Person with " + person + " was inserted successfully");
        return new Message(new Timestamp(new Date().getTime()) + " New person was inserted: " + person);
    }

}
