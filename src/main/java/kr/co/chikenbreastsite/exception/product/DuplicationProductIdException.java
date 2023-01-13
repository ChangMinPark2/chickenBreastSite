package kr.co.chikenbreastsite.exception.product;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class DuplicationProductIdException extends BusinessLogicException {
    public DuplicationProductIdException(){super(ErrorCodeType.DUPLICATION_PRODUCT_ID);}
}
