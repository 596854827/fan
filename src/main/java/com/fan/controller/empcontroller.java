package com.fan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fan.model.employee;
import com.fan.service.UserService;

@RestController
@RequestMapping("/users")
public class empcontroller {
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<employee> listUser(){
		return userservice.findAll();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public employee create(@RequestBody employee user){
		return userservice.save(user);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id){
		userservice.delete(id);
		return "success";
	}
}