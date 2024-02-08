package com.zwiggy.zwiggyengine.exception;


/**
 * @author piyush
 * User Validation custom exception
 */
public class UserValidationException extends Exception {

	public UserValidationException(String errorMsg) {
		super(errorMsg);
	}
}
