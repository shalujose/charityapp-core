package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Amount;
import com.revature.model.Category;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImp;
import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exception.DBException;
import com.revature.util.Logger;

public class AdminService {

	private static final Logger logger=Logger.getInstance();
	AdminDAO admindao=new AdminDAO();
	public User findByAdminNameAndPassword(String name, String password) {
		User user=null;
		try {
			user=admindao.findByAdminNamePassword(name, password);
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public void sendFundRequest(int categoryId, double amount) throws Exception {
		try {
			admindao.fundRequest(categoryId,amount);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	public void addCategory(String categoryName) {
		try {
			admindao.addCategory(categoryName);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public List<Transaction> viewResponse()
	{
		List<Transaction> list=null;
	    try {
	    	AdminDAOImp dao= new AdminDAO();
            try {
				list = dao.viewResponse();
			} catch (DBException e) {
				e.printStackTrace();
			}
	        displayTrans(list);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return list;
	}
	public static void displayTrans(List<Transaction> list) {
		StringBuilder content=new StringBuilder();
        content.append("transaction_id\t\tdate_of_transaction\t\tfundrequest_id\tcate_id\t\tdonor_id\tname\t\tamount\n");
		for (Transaction admin : list) {
			 content.append(admin.getTransactionId()).append("\t\t\t");
	            content.append(admin.getDateOfTransaction()).append("\t\t\t");
	            content.append(admin.getFundrequestId()).append("\t");
	            content.append(admin.getCategoryId()).append("\t\t");
	            content.append(admin.getDonorId()).append("\t\t");
	            content.append(admin.getName()).append("\t\t");
	            content.append(admin.getAmount()).append("\t\t");
	            content.append("\n");
	        }
	        logger.info(content);
		}
	public List<Category> viewCategory()
	{
		List<Category> list=null;
	    try {
	    	IUserDAO dao= new UserDAO();
            list = dao.displayCategory();
            displayCategory(list);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return list;
	}
	public static void displayCategory(List<Category> list) {
		StringBuilder content=new StringBuilder();
        content.append("category_id\t\tcategory_name\n");
		for (Category admin : list) {
			 content.append(admin.getCategory_id()).append("\t\t");
	            content.append(admin.getCategory_name()).append("\t\t");
	            content.append("\n");
	        }
	        logger.info(content);
		}
	
	public List<Amount> closeRequest()
	{
		List<Amount> list=null;
	    try {
	    	AdminDAOImp dao= new AdminDAO();
            list = dao.matchAmount();
            displayAmount(list);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return list;
	}
	public static void displayAmount(List<Amount> list) {
		StringBuilder content=new StringBuilder();
        content.append("request_id\t\tTargetAmount\t\tDonatedAmount\n");
		for (Amount admin : list) {
			 content.append(admin.getRequestId()).append("\t\t");
	            content.append(admin.getRequestAmount()).append("\t\t");
	            content.append(admin.getTotalAmount()).append("\t");
	            
	            content.append("\n");
	        }
	        logger.info(content);
		}
}
