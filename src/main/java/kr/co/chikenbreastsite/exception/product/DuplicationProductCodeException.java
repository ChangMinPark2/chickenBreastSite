package kr.co.chikenbreastsite.exception.product;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class DuplicationProductCodeException extends BusinessLogicException {
    public DuplicationProductCodeException(){super(ErrorCodeType.DUPLICATION_PRODUCT_CODE);}
}
