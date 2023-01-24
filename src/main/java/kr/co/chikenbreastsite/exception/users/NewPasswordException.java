package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class NewPasswordException extends BusinessLogicException {
    public NewPasswordException(){super(ErrorCodeType.NEW_PASSWORD);}
}
