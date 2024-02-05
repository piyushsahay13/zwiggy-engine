/**
 * 
 */
package com.zwiggy.zwiggyengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
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
	protected ResponseEntity<ErrorResponse> handleUserValidation(String errDes){
		ErrorResponse err = new ErrorResponse();
		err.setErrCd(errDes.substring(0, 10));
		err.setErrMsg(errDes.substring(11));
//		err.setStkTrace(errDes);
		log.error(err.getErrMsg() + " ::: " +err.getStkTrace());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidUserException.class)
	protected ResponseEntity<ErrorResponse> handleInvalidUseExcp(String errDes) {
		ErrorResponse err = new ErrorResponse();
		err.setErrCd(errDes.substring(0, 10));
		err.setErrMsg(errDes.substring(11));
//		err.setStkTrace(errDes);
		log.error(err.getErrMsg() + " ::: " +err.getStkTrace());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RepositoryOperationException.class)
	protected ResponseEntity<ErrorResponse> handleRepoOperationExcp(String errDes, Throwable trace) {
		ErrorResponse err = new ErrorResponse();
		err.setErrCd(errDes.substring(0, 10));
		err.setErrMsg(errDes.substring(11));
		err.setStkTrace(trace.getStackTrace());
		log.error(err.getErrMsg() + " ::: " +trace.getStackTrace());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleGeneralException(Exception trace) {
		ErrorResponse err = new ErrorResponse();
		String errDes = ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.GENERALEXCEPTION);
		err.setErrCd(errDes.substring(0, 10));
		err.setErrMsg(errDes.substring(11));
		err.setStkTrace(trace.getStackTrace());
		log.error(err.getErrMsg() + " ::: " + trace.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
