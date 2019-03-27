package com.fan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.model.employee;

@Repository
public interface empdao extends CrudRepository<employee,Long> {
	employee findByUsername(String username);
}

