package com.amudhan.caveatemptor.test.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.service.UserService;

public class UserServiceTest extends ServiceTest{
	@Inject
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
		
	@Test
	void getUsers(){
		List<User> users = userService.getUsers();
		for(User user:users){
			logger.info(user.getId()+" "+user.getName().getFirstName()+" "+user.getName().getLastName());
		}
		Assert.assertNotNull(users);
	}
	
	@Test
	void getUser(){
		User user = userService.getUser(1);
		logger.info(user.getId()+" "+user.getName().getFirstName()+" "+user.getName().getLastName());
		Assert.assertNotNull(user);
		Assert.assertEquals("James",user.getName().getFirstName());
		Assert.assertEquals("Bond",user.getName().getLastName());
	}
	
}
