package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class UsersNotRoleException extends BusinessLogicException {
    public UsersNotRoleException(){super(ErrorCodeType.USER_NOT_ROLE);}
}
