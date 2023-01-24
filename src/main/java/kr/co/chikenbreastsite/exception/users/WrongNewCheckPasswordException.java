package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class WrongNewCheckPasswordException extends BusinessLogicException {
    public WrongNewCheckPasswordException(){super(ErrorCodeType.WRONG_NEW_CHECK_PASSWORD);}
}
