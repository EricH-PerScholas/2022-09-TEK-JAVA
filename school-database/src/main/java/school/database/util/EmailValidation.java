package school.database.util;

import org.apache.commons.lang3.StringUtils;

public class EmailValidation {
	
	// HOMEWORK 
	// create a new method for validating a phone number and return true or false
	// a phone number must have 9 numbers, any more or less is an error
	// a phone number is allowed to have '-' '.' or ' ' in the phone number any number of times at any location
	// a phone number must not be null or empty
	// a phone number must not begin with 555
	//
	// create a test in the EmailValidationTest class .. that will test with at least 5 negative cases
	// craet a test that will validate 5 or more positive cases

	public boolean isValidEmail(String email) {
		// 1) make sure the string has an @ in it
		// 2) make sure the string has only letters or numbers before the @ sign
		// 3) make sure the string ends with a '.' and then 3 characters with no numbers
		// eric@dev.seriesreminder.com
		// 4) make sure the string is not empty and is not null

		// return true if all conditions are good otherwise false
		// the way I would start this is by checking negtive things first and returning

		// first I would check is null or empty and then could return false if so .. if
		// not
		// then can check the next step

		// can also use the apache string utils libraries for this

		if (email == null || email.equals("")) {
			return false;
		}

		if (!email.contains("@")) {
			return false;
		}

		String before = email.substring(0, email.indexOf("@"));
		if (!StringUtils.isAlphanumeric(before)) {
			return false;
		}
		
		String end = email.substring(email.lastIndexOf(".") + 1 );
		if ( ! StringUtils.isAlpha(end)) {
			return false;
		}
		
		if ( end.length() != 3 ) {
			return false;
		}
		
		return true;

	}
}
