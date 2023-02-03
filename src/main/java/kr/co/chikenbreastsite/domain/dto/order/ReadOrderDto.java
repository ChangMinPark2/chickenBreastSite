package kr.co.chikenbreastsite.domain.dto.order;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
public class ReadOrderDto {

    private LocalDate createAt;

    private String paymentMethod;

    private int totalPrice;

    private String usersName;

    private String productsName;

    private int price;

}
