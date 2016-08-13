package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.User;

public interface UserDao {
	/**
	 * Read operations
	 * **/
	public List<User> getUsers();
	public User getUser(long id);
	public void save(User user);
	public void delete(User user);
}
