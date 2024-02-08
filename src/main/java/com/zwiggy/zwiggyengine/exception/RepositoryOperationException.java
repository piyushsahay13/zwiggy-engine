/**
 * 
 */
package com.zwiggy.zwiggyengine.exception;

import java.io.Serial;
import java.util.NoSuchElementException;

/**
 * @author piyush
 * Custom Exception to handle repository operation related exception 
 */
public class RepositoryOperationException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 2441027781589132118L;

	public RepositoryOperationException(String message, IllegalArgumentException exp) {
		super(message,exp);
	}

	public RepositoryOperationException(String message, NoSuchElementException exp) {
		super(message,exp);
	}

}
