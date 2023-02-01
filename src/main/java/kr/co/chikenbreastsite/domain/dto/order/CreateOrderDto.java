package kr.co.chikenbreastsite.domain.dto.order;

import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
public class CreateOrderDto {

    @NotNull(message = "아이디를 입력하세요.")
    @Size(min = 5, max = 15, message = "아이디는 5~15자를 입력해주세요.")
    private String identity;

    @NotNull(message = "비밀번호를 입력하세요.")
    @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
    private String password;

    @NotNull(message = "상품을 입력해주세요")
    private String products; //productName

    @NotNull(message = "구입할 상품의 개수를 입력해주세요")
    private int numberOfProducts;

    @NotNull(message = "카드 혹은 현금을 입력해주세요")
    private String paymentMethod; //결제 방법
}
