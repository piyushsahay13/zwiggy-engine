/**
 * 
 */
package com.zwiggy.zwiggyengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zwiggy.zwiggyengine.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author piyush
 * Global Exception handler to throw exception response to end user
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserValidationException.class)
	protected ResponseEntity<ErrorResponse> handleUserValidation(String errcd){
		ErrorResponse err = new ErrorResponse();
		err.setErrCd(errcd);
		err.setErrMsg(errcd);
		err.setStkTrace(errcd);
		log.error(err.getErrMsg() + " ::: " +err.getStkTrace());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidUserException.class)
	protected ResponseEntity<ErrorResponse> handleInvalidUseExcp(String errDes) {
		ErrorResponse err = new ErrorResponse();
		err.setErrCd(errDes);
		err.setErrMsg(errDes);
		err.setStkTrace(errDes);
		log.error(err.getErrMsg() + " ::: " +err.getStkTrace());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
