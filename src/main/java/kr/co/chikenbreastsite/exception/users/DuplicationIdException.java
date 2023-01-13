package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class DuplicationIdException extends BusinessLogicException {
    public DuplicationIdException(){super(ErrorCodeType.DUPLICATION_ID);}
}
