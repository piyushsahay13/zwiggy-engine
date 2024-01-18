package com.zwiggy.zwiggyengine.exception;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;

/**
 * @author piyush
 * User Validation custom exception
 */
public class UserValidationException extends Exception {

	public UserValidationException(String errorMsg) {
		super(errorMsg);
	}
}
