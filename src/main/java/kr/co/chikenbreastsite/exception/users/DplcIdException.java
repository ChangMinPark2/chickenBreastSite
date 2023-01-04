package kr.co.chikenbreastsite.exception.users;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class DplcIdException extends BusinessLogicException {
    public DplcIdException(){super(ErrorCodeType.DPLC_ID);}
}
