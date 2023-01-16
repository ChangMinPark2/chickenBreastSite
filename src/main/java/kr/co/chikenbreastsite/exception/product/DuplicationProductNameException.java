package kr.co.chikenbreastsite.exception.product;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class DuplicationProductNameException extends BusinessLogicException {
    public DuplicationProductNameException(){super(ErrorCodeType.DUPLICATION_PRODUCT_NAME);}
}
