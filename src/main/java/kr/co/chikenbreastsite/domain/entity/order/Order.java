package kr.co.chikenbreastsite.domain.entity.order;


import kr.co.chikenbreastsite.domain.dto.order.CreateOrderDto;
import kr.co.chikenbreastsite.domain.dto.order.ReadOrderDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "tbl_orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_price")
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public Order(LocalDate createAt, String paymentMethod, int totalPrice,
                 Users users, Product product){
        this.createAt = createAt;
        this.paymentMethod = paymentMethod;
        this.users = users;
        this.product = product;
        this.totalPrice = totalPrice;
    }

    public static Order of(CreateOrderDto createOrderDto, LocalDate date,
                           Users users, Product product, int totalPrice){
        return Order.builder()
                .createAt(date)
                .paymentMethod(createOrderDto.getPaymentMethod())
                .users(users)
                .product(product)
                .totalPrice(totalPrice)
                .build();
    }

    public static ReadOrderDto of(Order order){
        return ReadOrderDto.builder()
                .createAt(order.getCreateAt())
                .paymentMethod(order.getPaymentMethod())
                .totalPrice(order.getTotalPrice())
                .usersName(order.getUsers().getName())
                .productsName(order.getProduct().getName())
                .price(order.getTotalPrice())
                .build();
    }

}
