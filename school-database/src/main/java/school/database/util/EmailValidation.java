package school.database.util;

import org.apache.commons.lang3.StringUtils;

public class EmailValidation {

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
