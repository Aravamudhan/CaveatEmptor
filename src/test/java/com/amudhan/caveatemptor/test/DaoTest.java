package com.amudhan.caveatemptor.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.utils.RandomAlphaGenerator;

/*
 * The methods in classes that extend this will be transactional.
 * */
@Test
@ContextConfiguration("classpath:configuration/applicationContext-core-test.xml")
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@Transactional
public abstract class DaoTest extends AbstractTestNGSpringContextTests {
	@PersistenceContext
	protected EntityManager entityManager;
	protected RandomAlphaGenerator randomStringGenerator = new RandomAlphaGenerator();
}
