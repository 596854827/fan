package com.fan.service;

import java.util.Arrays;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fan.dao.empdao;
import com.fan.model.employee;

@Service(value="userService")
public class UserServiceImpl implements UserDetailsService,UserService{

	
	@Autowired
	private empdao userDao;
	
	@Override
	public employee save(employee user) {
		
		return userDao.save(user);
	}

	@Override
	public List<employee> findAll() {
	
		List<employee> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		
		userDao.delete(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		employee user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("invalid username/password");
		}
		return new org.springframework.security.core.userdetails.User
				(String.valueOf(user.getId()),user.getPassword(),getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}