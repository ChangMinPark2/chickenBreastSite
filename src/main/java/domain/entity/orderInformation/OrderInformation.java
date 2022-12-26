package domain.entity.orderInformation;


import domain.entity.orderList.OrderList;
import domain.entity.product.Product;
import domain.entity.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_orderInformation")
@NoArgsConstructor
@AllArgsConstructor
public class OrderInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderinom;
    //기본 키 생성을 데이터베이스에 위임해준다. Entity를 등록할 때 DB에서 AUTO_INCREAMENT 하며 PK를 생성 후 INSERT한다.

    private String productNom;

    private String orderQuantity;

    private String orderPrice;

    @ManyToOne
    @JoinColumn(name = "orderlnom")
    private OrderList orderList;

    @ManyToOne
    @JoinColumn(name = "pno")
    private Product product;

}
