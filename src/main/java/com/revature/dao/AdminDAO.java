package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Amount;
import com.revature.model.Request;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.Logger;
import com.revature.exception.DBException;

public class AdminDAO implements AdminDAOImp { // implementation of AdminDAOImp interface for AdminDAO

	private static final Logger logger=Logger.getInstance(); 
	public void fundRequest(int categoryId, double amount) throws DBException { // This method is used for generate fund request

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into fund_request(category_Id,amount) values (?,?)";
		try {

			pst = con.prepareStatement(sql);
			pst.setInt(1, categoryId);
			pst.setDouble(2, amount);
			pst.executeUpdate();
			logger.debug("Your Request has been successfully sended");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to make fund request ", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	public List<Request> viewRequest() throws SQLException { // This method is used to display fund request from the
																// table

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select r.request_id,r.category_Id,r.date_of_request,r.amount,r.status,c.category_name from fund_request r inner join request_category c where r.category_Id=c.category_id and status='Open' order by date_of_request";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			List<Request> list = new ArrayList<Request>(); // ArrayList for display the table data
			while (rs.next()) {
				Request requestlist = toRow1(rs);
				list.add(requestlist);
			}
			return list;
		} finally {
			ConnectionUtil.close(con, pst);
			ConnectionUtil.closeRs(rs);
		}
	}

	private static Request toRow1(ResultSet rs) throws SQLException {

		int requestId = rs.getInt("request_id");
		int requestName = rs.getInt("category_Id");
		String categoryName=rs.getString("category_name");
		String dateOfRequest = rs.getString("date_of_request");
		double amount = rs.getInt("amount");
		String status = rs.getString("status");

		Request requestlist = new Request();
		requestlist.setRequestId(requestId);
		requestlist.setCategory_id(requestName);
		requestlist.setCategory_name(categoryName);
		requestlist.setDateOfRequest(dateOfRequest);
		requestlist.setAmount(amount);
		requestlist.setStatus(status);

		return requestlist;
	}

	public List<Transaction> viewResponse() throws DBException, SQLException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select t.transaction_id,t.date_of_transaction,t.fundrequest_id,d.name,t.donor_id,t.amount from transactions t inner join donors_details d where t.donor_id=d.id order by t.transaction_id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			List<Transaction> list = new ArrayList<Transaction>(); // ArrayList for display the transaction data
			while (rs.next()) {
				Transaction response = toRow2(rs);
				list.add(response);
			}

			return list;
		} finally {
			ConnectionUtil.close(con, pst);
			ConnectionUtil.closeRs(rs);
		}

	}

	private static Transaction toRow2(ResultSet rs) throws SQLException {

		int transactionId = rs.getInt("transaction_id");
		String dateOfTransaction = rs.getString("date_of_transaction");
		int fundRequestId = rs.getInt("fundrequest_id");
		String name=rs.getString("name");
		int donorId = rs.getInt("donor_id");
		double amount = rs.getInt("amount");

		Transaction response = new Transaction();
		response.setTransactionId(transactionId);
		response.setDateOfTransaction(dateOfTransaction);
		response.setFundrequestId(fundRequestId);
		response.setName(name);
		response.setDonorId(donorId);
		response.setAmount(amount);
		return response;
	}

	public List<Amount> matchAmount() throws SQLException {

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// joins two tables to display Request amount and donated amount
			String sql = "select r.request_id,r.amount,sum(t.amount) as Total from fund_request r inner join transactions t where r.request_id=t.fundrequest_id and r.status='Open' group by r.request_id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			List<Amount> list = new ArrayList<Amount>(); // ArrayList for display the amounts
			while (rs.next()) {
				Amount displayAmount = toRow3(rs);
				list.add(displayAmount);
			}

			return list;
		} finally {
			ConnectionUtil.close(con, pst);
			ConnectionUtil.closeRs(rs);
		}

	}

	private static Amount toRow3(ResultSet rs) throws SQLException {

		int fundRequestId = rs.getInt("request_id");
		double ramount = rs.getInt("amount");
		double tamount = rs.getDouble("Total");

		Amount displayAmount = new Amount();
		displayAmount.setRequestId(fundRequestId);
		displayAmount.setRequestAmount(ramount);
		displayAmount.setTotalAmount(tamount);

		return displayAmount;
	}

	public static void closeRequest(int request_id) throws DBException { // This method is used for generate fund request

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "update fund_request set status='Closed' where request_id=?";
		try {

			pst = con.prepareStatement(sql);
			pst.setInt(1, request_id);

			pst.executeUpdate();
			logger.debug(" Your Request is Closed!!! ");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to close request", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	public void resetPasword(String password) throws DBException { // This method is used for reset admin password

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "update admin_details set password=?";
		try {

			pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.executeUpdate();
			logger.debug(" Your Password is changed!!! ");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to change password", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}

	public void addCategory(String categoryName) throws DBException { // addCategory() used to add different request categories 

		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into request_category(category_name) values (?)";
		try {

			pst = con.prepareStatement(sql);
			pst.setString(1, categoryName);
			pst.executeUpdate();
			logger.debug(" New category added successfully!!!");
		} catch (SQLException e) {
			throw new DBException("Unable to add new category ", e);
		} finally {
			ConnectionUtil.close(con, pst);
		}

	}
	
	public User findByAdminNamePassword(String name, String password) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select name,password from admin_details where name = ? and Password = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
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

		String name = rs.getString("name");
		String password = rs.getString("password");
		User user = new User();
		user.setName(name);
		user.setPassword(password);

		return user;
	}
}
