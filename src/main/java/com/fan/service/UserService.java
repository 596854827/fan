package com.fan.service;

import java.util.List;

import com.fan.model.employee;

public interface UserService {
	employee save(employee user);
	
	List<employee> findAll();
	
	void delete(long id);
}
