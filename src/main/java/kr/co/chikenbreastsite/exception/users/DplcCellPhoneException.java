package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class DplcCellPhoneException extends BusinessLogicException {
    public DplcCellPhoneException(){super(ErrorCodeType.DPLC_CELLPHONE);}
}
