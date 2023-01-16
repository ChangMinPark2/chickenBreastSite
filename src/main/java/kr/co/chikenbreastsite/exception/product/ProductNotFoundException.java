package kr.co.chikenbreastsite.exception.product;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class ProductNotFoundException extends BusinessLogicException {
    public ProductNotFoundException(){super(ErrorCodeType.PRODUCT_NOT_FOUND);}
}
