package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.constant.UserQueries;
import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Query query = entityManager.createNamedQuery(UserQueries.GETALLUSERS);
		List<User> users = (List<User>)query.getResultList();
		return users;
	}

	@Override
	public User getUser(long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public void delete(User user) {
		entityManager.remove(user);
	}
	

}
