/**
 * 
 */
package com.zwiggy.zwiggyengine.constant;

import lombok.Getter;

/**ErrorMsgEnum
 * @author piyush
 * Enum to store error message and code combination
 */
@Getter
public enum ErrorMsgEnum {
	USERIDERROR("ZWENG-0001", "User email ID Validation failed."),
    INVALIDERRORCODE("ZWENG-0002", "Error Code Invalid"),
    THIRD("key3", "value3");

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
