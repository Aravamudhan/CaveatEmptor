package com.amudhan.caveatemptor.test;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.service.UserService;

@Test
@ContextConfiguration("classpath:configuration/applicationContext-core-test.xml")
public class ServicesTest extends AbstractTestNGSpringContextTests{
	@Inject
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(ServicesTest.class);
	
	@Test
	void getUsers(){
		List<User> users = userService.getUsers();
		for(User user:users){
			logger.info(user.toString());
		}
		Assert.assertNotNull(users);
	}
}
