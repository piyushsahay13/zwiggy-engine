/**
 * 
 */
package com.zwiggy.zwiggyengine.exception;

import java.io.Serial;

/**
 * @author piyush
 * Custom Exception to show invalid usertype 
 *
 */
public class InvalidUserException extends Exception {


	@Serial
	private static final long serialVersionUID = 6281995274559053591L;

	public InvalidUserException(String errMsg) {
		super(errMsg);
	}
}
