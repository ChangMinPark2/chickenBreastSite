package kr.co.chikenbreastsite.domain.dto.product;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class AddProductDto {

    @NotBlank(message = "상품 id를 입력하지 않으셨습니다.") //상품 번호라고 적는게 맞는거 같아서 조언을 구하고 싶음.
    private String productIdentity;

    @NotBlank(message = "상품 이름을 입력하지 않으셨습니다.")
    private String name;

    @NotBlank(message = "상품 가격을 입력하지 않으셨습니다.")
    private String price;

    private String inventoryQuantity;   //재고수량
}
