package br.com.rnrafa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rnrafa.entity.User;
import br.com.rnrafa.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices service;
	
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll(){
		return service.findAll();
	}
}
