/**
 * 
 */
package com.zwiggy.zwiggyengine.exception;

import com.zwiggy.zwiggyengine.constant.AppConstant;
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
	
	@ExceptionHandler({UserValidationException.class, InvalidUserException.class,EmailDeliveryException.class})
	protected ResponseEntity<ErrorResponse> handleUserValidation(Exception ex) {
		ErrorResponse err = new ErrorResponse();
		if (ex instanceof UserValidationException || ex instanceof InvalidUserException) {
			String errDes = ex.getMessage();
			err.setErrCd(errDes.substring(0, 10));
			err.setErrMsg(errDes.substring(11));
			log.error(err.getErrMsg() + AppConstant.COLANSEP + ex.getStackTrace());
			return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@ExceptionHandler(RepositoryOperationException.class)
	protected ResponseEntity<ErrorResponse> handleRepoOperationExp(RuntimeException ex) {
		ErrorResponse err = new ErrorResponse();
		String errDes = ex.getMessage();
		err.setErrCd(errDes.substring(0, 10));
		err.setErrMsg(errDes.substring(11));
		err.setExcCause(ex.getCause().toString());
		log.error(err.getErrMsg() + AppConstant.COLANSEP + ex.getStackTrace());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleGeneralException(Exception trace) {
		ErrorResponse err = new ErrorResponse();
		String errDes = ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.GENERALEXCEPTION);
		err.setErrCd(errDes.substring(0, 10));
		err.setErrMsg(errDes.substring(11));
		err.setExcCause(trace.getMessage());
		log.error(err.getErrMsg() + AppConstant.COLANSEP + trace.getStackTrace());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
