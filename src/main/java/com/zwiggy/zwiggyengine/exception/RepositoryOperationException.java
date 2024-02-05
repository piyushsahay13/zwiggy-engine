/**
 * 
 */
package com.zwiggy.zwiggyengine.exception;

/**
 * @author piyush
 * Custom Exception to handle repository operation related exception 
 */
public class RepositoryOperationException extends Exception {

	private static final long serialVersionUID = 2441027781589132118L;

	public RepositoryOperationException(String msg, Throwable trace) {
		super(msg, trace);
	}

}
