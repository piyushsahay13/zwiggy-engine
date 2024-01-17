/**
 * 
 */
package com.zwiggy.zwiggyengine.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zwiggy.zwiggyengine.constant.ErrorMsgConstants;
import com.zwiggy.zwiggyengine.constant.RegexConstanst;
import com.zwiggy.zwiggyengine.exception.UserValidationException;

/**
 * @author Piyush
 * User detail validation utility 
 */
public class RequestValidator {

	private static final Pattern pattern = Pattern.compile(RegexConstanst.EMAILREGEX);

	public static void validateUserId(Optional<String> userid) throws UserValidationException {
		if(userid.isEmpty() || !isValidEmail(userid.toString()))
			throw new UserValidationException(ErrorMsgConstants.INVALID_USERID);
	}

	private static boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
