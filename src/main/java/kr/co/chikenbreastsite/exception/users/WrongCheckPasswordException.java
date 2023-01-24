package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class WrongCheckPasswordException extends BusinessLogicException {
    public WrongCheckPasswordException(){super(ErrorCodeType.WRONG_CHECK_PASSWORD);}
}
