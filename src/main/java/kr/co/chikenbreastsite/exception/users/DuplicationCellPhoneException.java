package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class DuplicationCellPhoneException extends BusinessLogicException {
    public DuplicationCellPhoneException(){super(ErrorCodeType.DUPLICATION_CELLPHONE);}
}
