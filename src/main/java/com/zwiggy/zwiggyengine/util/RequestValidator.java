/**
 * 
 */
package com.zwiggy.zwiggyengine.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.constant.RegexConstanst;
import com.zwiggy.zwiggyengine.exception.UserValidationException;

/**
 * @author piyush
 * User detail validation utility 
 */
public class RequestValidator {

	private static final Pattern pattern = Pattern.compile(RegexConstanst.EMAILREGEX);

	public static void validateUserId(Optional<String> userid) throws UserValidationException {
		String email = userid.orElseThrow(() -> new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERIDERROR)));
		if(!isValidEmail(email))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERIDERROR));
	}

	private static boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
