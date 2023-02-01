package kr.co.chikenbreastsite.exception.order;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class ProductDoesNotHaveException extends BusinessLogicException {
    public ProductDoesNotHaveException(){super(ErrorCodeType.PRODUCT_DOES_NOT_HAVE);}
}
