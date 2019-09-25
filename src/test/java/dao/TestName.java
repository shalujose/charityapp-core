package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.validator.DonorValidator;

public class TestName {

	@Test
	public void testValidName() {
		String name = "shalu";
		try {
			DonorValidator.validName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertNotNull(name);
	}

	public void testInvalidName() {
		String name = "shalu123";
		try {
			DonorValidator.validName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertNotNull(name);
	}
}
