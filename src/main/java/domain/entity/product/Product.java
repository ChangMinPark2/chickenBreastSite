package domain.entity.product;


import domain.entity.productClassification.ProductClassification;
import domain.entity.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String name;

    private String price;

    private String image;

    private String famousProduct;

    private String inventoryQuantity;

    @ManyToOne
    @JoinColumn(name = "pcno")
    private ProductClassification productClassification;

}
