package kr.co.chikenbreastsite.domain.dto.product;

import kr.co.chikenbreastsite.domain.entity.product.UserRole;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class DeleteProductDto {

    @NotNull(message = "상품 이름을 입력하지 않으셨습니다.")
    private String name;

    @NotNull(message = "일반 사용자인지, 관리자 인지 기입해주세요")
    private UserRole userRole;
}
