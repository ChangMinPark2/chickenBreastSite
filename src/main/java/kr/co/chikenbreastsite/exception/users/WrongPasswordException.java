package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class WrongPasswordException extends BusinessLogicException {
    public WrongPasswordException(){
        super(ErrorCodeType.WRONG_PASSWORD);
    }
}
