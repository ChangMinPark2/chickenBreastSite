package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class UsersNotFoundException extends BusinessLogicException {
    public UsersNotFoundException() {
        super(ErrorCodeType.USER_NOT_FOUND);
    }
}
