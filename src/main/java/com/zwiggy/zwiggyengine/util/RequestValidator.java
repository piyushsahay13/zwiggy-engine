/**
 * 
 */
package com.zwiggy.zwiggyengine.util;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.constant.RegexConstanst;
import com.zwiggy.zwiggyengine.exception.InvalidUserException;
import com.zwiggy.zwiggyengine.exception.UserValidationException;

import com.zwiggy.zwiggyengine.model.Address;
import com.zwiggy.zwiggyengine.model.Customer;
import com.zwiggy.zwiggyengine.model.Restaurant;
import com.zwiggy.zwiggyengine.model.UserType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author piyush User detail validation utility
 */
@Slf4j
public class RequestValidator {

	private static final Pattern pattern = Pattern.compile(RegexConstanst.EMAILREGEX);

	public static void validateUser(Customer user,char usertyp) throws UserValidationException, InvalidUserException {
		validateUserId(Optional.ofNullable(user.getEmail()));
		validateContactNum(user.getContactNo());
		validateName(user.getFName(), user.getSName());
		validateUserType(user.getUserType(),usertyp);
		validaAddress(user.getAddress());
	}
	public static void validateRestaurant(Restaurant user, char usertyp) throws UserValidationException, InvalidUserException {
		validateUserId(Optional.ofNullable(user.getEmail()));
		validateContactNum(user.getContactNo());
		validateName(user.getFName(), user.getSName());
		validateUserType(user.getUserType(),usertyp);
		validaAddress(user.getAddress());
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
		if(contact.length()!=10 || !CommonUtility.isNumeric(contact))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERCONTACFORMATERR));
	}

	private static void validateName(String fName, String sName) throws UserValidationException {
		if(fName.matches(RegexConstanst.CONTAINNUMANDSPCLCHAR) || sName.matches(RegexConstanst.CONTAINNUMANDSPCLCHAR))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.NAMEISNOTVALID));
	}

	private static void validateUserType(UserType usrTyp,char usertyp) throws UserValidationException, InvalidUserException {
		if(usertyp != UserType.getCodefrmUsrType(usrTyp))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.USERTYPEMISMATCH));
	}

	private static void validaAddress(List<Address> address) throws UserValidationException {
		List<Double> geoloc = CommonUtility.geolocConverter(address.get(0).getGoogleMapLoc());
		if(!CommonUtility.isValidLatitude(geoloc.get(0)) || !CommonUtility.isValidLongitude(geoloc.get(1)))
			throw new UserValidationException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.GEOLOCERROR));

	}

}
