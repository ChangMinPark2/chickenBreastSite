package kr.co.chikenbreastsite.domain.dto.product;

import lombok.Getter;

@Getter
public class AddProductDto {

    private String productIdentity;

    private String name;

    private String price;

    private String inventoryQuantity;   //재고수량
}
