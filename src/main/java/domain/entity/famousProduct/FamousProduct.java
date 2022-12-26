package domain.entity.famousProduct;


import domain.entity.product.Product;
import domain.entity.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_famousProduct")
@NoArgsConstructor
@AllArgsConstructor

public class FamousProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fpnom;

    private String productNum;

    @OneToOne
    @JoinColumn(name = "pno")
    private Product product;



}
