package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exception.DBException;
import com.revature.model.User;

public class TestAdminLogin {

	@Test
	public void TestAdmin() {

		IUserDAO userobj = new UserDAO();
		String name = "";
		String password = "";
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

	public void TestInvalidAdmin() {

		IUserDAO userobj = new UserDAO();
		String name = "admin";
		String password = "pass123";
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

	public void TestValidAdmin() {

		IUserDAO userobj = new UserDAO();
		String name = "admin";
		String password = "admin@123";
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
