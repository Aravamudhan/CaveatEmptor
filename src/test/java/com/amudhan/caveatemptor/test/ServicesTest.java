package com.amudhan.caveatemptor.test;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.Category;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.service.CategoryService;
import com.amudhan.caveatemptor.service.UserService;

@Test
@ContextConfiguration("classpath:configuration/applicationContext-core-test.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class ServicesTest extends AbstractTestNGSpringContextTests{
	@Inject
	private UserService userService;
	@Inject
	private CategoryService categoryService;
	private static final Logger logger = LoggerFactory.getLogger(ServicesTest.class);
		
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
	}
	
	@Test
	void getCategory(){
		Category category = categoryService.getCategory(9);
		logger.info(category.getId()+" "+category.getName());
		Assert.assertNotNull(category);
	}
}
