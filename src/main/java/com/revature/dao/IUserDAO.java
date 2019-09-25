package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.model.Category;

import com.revature.model.User;
import com.revature.exception.DBException;

public interface IUserDAO {
	
	User findByNamePassword(String email,String password) throws SQLException, DBException;
	public void register(User user) throws DBException;
	public List<Category> displayCategory() throws SQLException;
}
