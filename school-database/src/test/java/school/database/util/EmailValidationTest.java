package school.database.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailValidationTest {
	
	@Test
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
	public void isEmailValidTest() {
		EmailValidation ev = new EmailValidation();
		
		Assertions.assertFalse(ev.isValidEmail(null));
		Assertions.assertFalse(ev.isValidEmail(""));
		Assertions.assertFalse(ev.isValidEmail("ericseriesreminder.com"));
		Assertions.assertFalse(ev.isValidEmail("er#ic@seriesreminder.com"));
		Assertions.assertFalse(ev.isValidEmail("eric@seriesreminder.co"));
		
		Assertions.assertTrue(ev.isValidEmail("eric@seriesreminder.com"));
	}
}
