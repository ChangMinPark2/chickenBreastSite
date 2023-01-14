package kr.co.chikenbreastsite.exception.product;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ErrorCodeType;

public class ProductDoesNotAlreadyExistException extends BusinessLogicException {
    public ProductDoesNotAlreadyExistException(){super(ErrorCodeType.PRODUCT_DOES_NOT_ALREADY_EXIST);}
}
