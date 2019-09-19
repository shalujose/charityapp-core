package dao;

import org.junit.Test;

import com.revature.validator.DonorValidator;

public class TestPasswordValidator {

	@Test
	public void testValid() {

		
		String name = "na";
		String password = "123456@78a";
		try {
			DonorValidator.passwordValidation(name, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void testInvalid() {

		
		String name = "na";
		String password = "123456@78";
		try {
			DonorValidator.passwordValidation(name, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
