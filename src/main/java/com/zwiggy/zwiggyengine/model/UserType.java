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
    USER('C',"Customer"),
    RESTAURANT('R',"Restaurant"),
    USER_RESTAURANT('Z',"Restaurant User");
    
    
    private final char userTypeCode;
    private final String userTypeDesc;

    UserType(char userTypeCode, String userTypeDesc) {
        this.userTypeCode = userTypeCode;
        this.userTypeDesc = userTypeDesc;
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
            if (usr.userTypeDesc.equals(usrDesc)) {
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
    
    public static char getCodefrmUsrType(UserType usrTyp) throws InvalidUserException {
        for (UserType usr : values()) {
            if (usr.equals(usrTyp)) {
                return usr.userTypeCode;
            }
        }
        throw new InvalidUserException(ErrorMsgEnum.getByErrorCode(ErrorMsgEnum.INVALIDUSER));
    }
}
