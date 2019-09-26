package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Request;
import com.revature.model.User;
import com.revature.util.Logger;
import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImp;
import com.revature.dao.UserDAO;
import com.revature.exception.DBException;

public class UserService {
	
	private static final Logger logger=Logger.getInstance();
	UserDAO userdao=new UserDAO();
	public User registerNow(User user) {
		try {
			userdao.register(user);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return user;
	}
	public User findByNameAndPassword(String email, String password) throws DBException {
		User user=null;
		try {
			user = userdao.findByNamePassword(email, password);
			if(user==null) {
				throw new DBException("Invalid login");
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	public List<Request> viewRequest()
	{
		List<Request> list=null;
	    try {
	    	AdminDAOImp dao= new AdminDAO();
            list = dao.viewRequest();
	        display(list);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return list;
	}
	public static void display(List<Request> list) {
		StringBuilder content=new StringBuilder();
        content.append("request_id\tcategory_Id\t\tcategory_name\t\t\tdate_of_request\t\t\tamount\t\tstatus\n");
		for (Request admin : list) {
			 content.append(admin.getRequestId()).append("\t\t\t");
	            content.append(admin.getCategory_id()).append("\t\t\t");
	            content.append(admin.getCategory_name()).append("\t\t");
	            content.append(admin.getDateOfRequest()).append("\t\t");
	            content.append(admin.getAmount()).append("\t\t");
	            content.append(admin.getStatus()).append("\t\t");
	            content.append("\n");
	        }
	        logger.info(content);
		}
	public void donateFundService(int fundrequestId, int cateId, int donorId, double amount) {
		
		try {
			UserDAO.donateFund(fundrequestId, cateId, donorId, amount);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
}
