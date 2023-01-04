package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class RequiredNotInputException extends BusinessLogicException {
    public RequiredNotInputException (){super(ErrorCodeType.REQUIRED_NOT_INPUT);}
}
