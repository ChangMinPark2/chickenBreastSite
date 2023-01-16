package kr.co.chikenbreastsite.domain.dto.product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetProductDto {

    private String name;

    private int price;

    private int inventoryQuantity;   //재고수량
}
