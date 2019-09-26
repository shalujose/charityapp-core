package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exception.DBException;
import com.revature.model.User;

public class TestUserDAO {

	@Test
	public void findNullNamePassword() {
		IUserDAO userobj=new UserDAO();
		String name="";
		String password="";
		User user = null;
		try {
			user = userobj.findByNamePassword(name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNull(user);
		
	}
	public void findValidNamePassword() {
		IUserDAO userobj=new UserDAO();
		String name="Ram";
		String password="ram@123";
		User user = null;
		try {
			user = userobj.findByNamePassword(name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotNull(user);
		
	}
	public void findInvalidNamePassword() {
		IUserDAO userobj=new UserDAO();
		String name="shilpa";
		String password="shi@123";
		User user = null;
		try {
			user = userobj.findByNamePassword(name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotNull(user);
		
	}

}
