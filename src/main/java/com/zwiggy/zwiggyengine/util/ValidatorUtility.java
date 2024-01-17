/**
 * 
 */
package com.zwiggy.zwiggyengine.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zwiggy.zwiggyengine.constant.RegexConstanst;
import com.zwiggy.zwiggyengine.exception.UserValidationException;

/**
 * @author Piyush
 * User detail validation utility 
 */
public class ValidatorUtility {

	private static final Pattern pattern = Pattern.compile(RegexConstanst.EMAILREGEX);

	public static boolean validateUserId(Optional<String> userid) {
		if(!userid.isEmpty() && isValidEmail(userid.toString())){
			return true;
		}
		else {
			throw new UserValidationException();
		}
	}

	private static boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
