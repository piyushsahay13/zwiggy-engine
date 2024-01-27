/**
 * 
 */
package com.zwiggy.zwiggyengine.model;

import com.zwiggy.zwiggyengine.constant.ErrorMsgEnum;
import com.zwiggy.zwiggyengine.exception.InvalidUserException;

import lombok.Getter;

/**
 * @author piyush
 * Enum To store UserType
 */

@Getter
public enum UserType {
    ADMIN('A',"Admin"),
    USER('U',"User"),
    RESTAURANT('R',"Restaurant");
    
    
    private final char userTypeCode;
    private final String UserTypeDesc;

    UserType(char userTypeCode, String UserTypeDesc) {
        this.userTypeCode = userTypeCode;
        this.UserTypeDesc = UserTypeDesc;
    }

    public static String getDescUsrCode(char usrCode) throws InvalidUserException {
        for (UserType usr : values()) {
            if (usr.userTypeCode == usrCode) {
                return usr.getUserTypeDesc();
            }
        }
        throw new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.INVALIDUSER) + usrCode);
    }
    
    public static char getCodeUsrDesc(String usrDesc) throws InvalidUserException {
        for (UserType usr : values()) {
            if (usr.UserTypeDesc.equals(usrDesc)) {
                return usr.getUserTypeCode();
            }
        }
        throw new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.INVALIDUSER) + usrDesc);
    }
    
    public static UserType getCodeUsrType(char usrCode) throws InvalidUserException {
        for (UserType usr : values()) {
            if (usr.userTypeCode == (usrCode)) {
                return usr;
            }
        }
        throw new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.INVALIDUSER) + usrCode);
    }
}
