package kr.co.chikenbreastsite.domain.dto.product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetProductDto {

    private String productIdentity;

    private String name;

    private String price;

    private String inventoryQuantity;   //재고수량
}
