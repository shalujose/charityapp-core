package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.Category;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.Logger;
import com.revature.exception.DBException;

public class UserDAO implements IUserDAO {

	private static final Logger logger=Logger.getInstance();
	public void register(User user) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into donors_details(name,gender,age,email,phone,password) values ( ?,?,?,?,?,?)";

		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getGender());
			pst.setInt(3, user.getAge());
			pst.setString(4, user.getEmail());
			pst.setLong(5, user.getPhone());
			pst.setString(6, user.getPassword());

			pst.executeUpdate();
			logger.debug("Your registration Successfully completed");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to insert donor data", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	public User findByNamePassword(String email, String password) throws DBException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,gender,age,email,phone,password from donors_details where email = ? and Password = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();

			User user = null;

			if (rs.next()) {
				user = new User();
				user = toRow(rs);
			}
			return user;
		} finally {
			ConnectionUtil.close(con, pst);
			ConnectionUtil.closeRs(rs);
		}
	}

	private User toRow(ResultSet rs) throws SQLException {

		String email = rs.getString("email");
		String password = rs.getString("password");
		int id = rs.getInt("id");
		String name=rs.getString("name");
	
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setId(id);
		user.setName(name);

		return user;
	}

	
	public static void donateFund(int fundrequestId, int donorId, double amount) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into transactions(fundrequest_id,donor_id,amount) values ( ?,?,?)";

		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, fundrequestId);
			pst.setInt(2, donorId);
			pst.setDouble(3, amount);
			pst.executeUpdate();
			logger.debug("Your Transaction Successfully completed\n");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to transfer fund", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	public List<Category> displayCategory() throws SQLException { // This method is used to display category list 

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select category_Id,category_name from request_category";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			List<Category> list1 = new ArrayList<Category>(); // ArrayList for display the table data
			while (rs.next()) {
				Category catelist = toRowCategory(rs);
				list1.add(catelist);
			}
			return list1;
		} finally {
			ConnectionUtil.close(con, pst);
			ConnectionUtil.closeRs(rs);
		}
	}
	private Category toRowCategory(ResultSet rs) throws SQLException {

		int cateId = rs.getInt("category_id");
		String cateName = rs.getString("category_name");
		Category catelist = new Category();
		catelist.setCategory_id(cateId);
		catelist.setCategory_name(cateName);
		
		return catelist;
	}
}
