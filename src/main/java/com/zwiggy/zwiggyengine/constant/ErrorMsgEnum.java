/**
 * 
 */
package com.zwiggy.zwiggyengine.constant;

import lombok.Getter;

/**
 * @author piyush
 * Enum to store error message and code combination
 */

@Getter
public enum ErrorMsgEnum {
	USERIDERROR("ZWENG-0001", "User email id validation failed."),
	INVALIDERRORCODE("ZWENG-0002", "Error code invalid"),
    INVALIDUSER("ZWENG-04", "Invalid user Type."),
	USERCONTACFORMATERR("ZWENG-0004", "Contact detail format is invalid."),
	NAMEISNOTVALID("ZWENG-0005", "UserName contains invalid value."),
	HIBERNATERROR("ZWENG-0006", "Exception occurred while performing repository operation"),
	GENERALEXCEPTION("ZWENG-0007", "Exception occurred!! please reach out to our support. ");
	
    private final String errorCode;
    private final String errorMsg;
    
    ErrorMsgEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static String getByErrorCode(ErrorMsgEnum errEnum) {
    	String errorCd =  errEnum.getErrorCode();
    	String result = null;
        for (ErrorMsgEnum err : values()) {
            if (err.errorCode.equals(errorCd)) {
                result = err.getErrorCode() + AppConstant.DASH + err.getErrorMsg();
                break;
            }
        }
        return result;
    }
}
