package util;

import java.sql.Connection;

import org.junit.Test;

import com.revature.Util.ConnectionUtil;
import junit.framework.TestCase;

public class TestConnectionUtil extends TestCase {
	@Test
	public void testConnection() {
		Connection connection = ConnectionUtil.getConnection();
		assertNotNull(connection);
	}

}
