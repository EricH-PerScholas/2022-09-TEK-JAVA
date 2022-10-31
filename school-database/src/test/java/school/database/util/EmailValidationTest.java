package school.database.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EmailValidationTest {
	
	@ParameterizedTest
	@ValueSource(strings = { "", "ericseriesreminder.com", "er#ic@seriesreminder.com", "eric@seriesreminder.co" })
	public void isEmailInvalidTest(String string) {
		EmailValidation ev = new EmailValidation();
		
		Assertions.assertFalse(ev.isValidEmail(string));
	}
}
