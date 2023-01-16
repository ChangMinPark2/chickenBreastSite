package kr.co.chikenbreastsite.domain.dto.product;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class AddProductDto {

    @NotNull(message = "상품 이름을 입력하지 않으셨습니다.")
    private String name;

    @NotNull(message = "상품 가격을 입력하지 않으셨습니다.")
    private int price;

    @NotNull(message = "상품의 수량을 입력하지 않으셨습니다.")
    private int inventoryQuantity;   //재고수량
}
