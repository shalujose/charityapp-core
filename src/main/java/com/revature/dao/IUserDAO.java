package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.Model.Category;

import com.revature.Model.User;
import com.revature.exception.DBException;

public interface IUserDAO {
	
	User findByNamePassword(String email,String password) throws SQLException, DBException;
	public void register(User user) throws DBException;
	//public void LoginAdmin() throws Exception;
	public List<Category> displayCategory() throws SQLException;
}
