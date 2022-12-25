package domain.entity.orderList;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import domain.entity.users.Users;


import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_orderList")
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderlnom;

    private String orderDate;

    private String payMethod;

    private String orderPay;

    private String id;

    @ManyToOne
    @JoinColumn(name = "uno")
    private Users users;




}
