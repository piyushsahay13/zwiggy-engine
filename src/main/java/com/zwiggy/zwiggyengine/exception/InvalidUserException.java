/**
 * 
 */
package com.zwiggy.zwiggyengine.exception;

/**
 * @author piyush
 * Custom Exception to show invalid usertype 
 *
 */
public class InvalidUserException extends Exception {
	
	private static final long serialVersionUID = 6281995274559053591L;

	public InvalidUserException(String errMsg) {
		super(errMsg);
	}
}
