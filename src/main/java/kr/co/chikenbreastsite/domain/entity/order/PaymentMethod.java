package kr.co.chikenbreastsite.domain.entity.order;

import kr.co.chikenbreastsite.domain.entity.product.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PaymentMethod {

    CARD("카드"),
    CASH("현금");

    String paymentMethod;

    public static PaymentMethod of(String paymentMethod){
        return Arrays.stream(PaymentMethod.values())
                .filter(g -> g.toString().equals(paymentMethod)) //g의 ADMIN, USER가 담기는 것
                .findAny().orElseThrow(() -> new RuntimeException("카드 혹은 현금만 가능합니다."));
    }

}
