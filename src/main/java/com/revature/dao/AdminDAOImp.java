package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Amount;
import com.revature.model.Request;
import com.revature.model.Transaction;
import com.revature.exception.DBException;

public interface AdminDAOImp {
	
	List<Request> viewRequest() throws SQLException;
	List<Transaction> viewResponse() throws SQLException, DBException;
	List<Amount> matchAmount() throws SQLException;
	public void fundRequest(int categoryId,double amount) throws DBException;
	public void resetPasword(String password) throws DBException;
	public void addCategory(String categoryName) throws DBException;
}
