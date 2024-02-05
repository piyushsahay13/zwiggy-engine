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
import com.zwiggy.zwiggyengine.model.Account;
import com.zwiggy.zwiggyengine.model.UserType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author piyush User detail validation utility
 */
@Slf4j
public class RequestValidator {

	private static final Pattern pattern = Pattern.compile(RegexConstanst.EMAILREGEX);

	public static void validateUser(Account user) throws UserValidationException {
		validateUserId(Optional.ofNullable(user.getEmail()));
		validateContactNum(user.getContactNo());
		validateName(user.getFName(), user.getSName());
		validateUserType(user.getUserType());
	}

	public static void validateUserId(Optional<String> userid) throws UserValidationException {
		String email = userid
				.orElseThrow(() -> new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERIDERROR)));
		log.info("Get details for user id {} : "+ email);
		if (!isValidEmail(email))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERIDERROR));
	}

	private static boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static void validateContactNum(String contact) throws UserValidationException {
		if(contact.length()>10 && !isNumeric(contact))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERCONTACFORMATERR));
	}

	private static void validateName(String fName, String sName) throws UserValidationException {
		if(fName.matches(RegexConstanst.CONTAINNUMANDSPCLCHAR) || sName.matches(RegexConstanst.CONTAINNUMANDSPCLCHAR))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.NAMEISNOTVALID));
	}

	private static void validateUserType(UserType usrTyp) {
	}

	public static boolean isNumeric(String str) {
		return str != null && str.matches(RegexConstanst.ONLYNUMREGEX);
	}

}
