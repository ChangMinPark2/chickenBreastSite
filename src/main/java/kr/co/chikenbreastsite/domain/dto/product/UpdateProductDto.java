package kr.co.chikenbreastsite.domain.dto.product;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UpdateProductDto {

    @NotBlank(message = "상품 번호를 입력하지 않으셨습니다.")
    private String productIdentity;

    @NotBlank(message = "상품 이름을 입력하지 않으셨습니다.")
    private String name;

    @NotBlank(message = "상품 가격을 입력하지 않으셨습니다.")
    private String price;

}
