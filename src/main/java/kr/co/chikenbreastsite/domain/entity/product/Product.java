package kr.co.chikenbreastsite.domain.entity.product;


import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @Column(name = "product_id")
    private Long productId;

    @Column
    private String name;

    @Column
    private String price;

    @Column(name = "inventory_quantity")
    private String inventoryQuantity;   //재고수량

    @Builder
    public Product(String name,
                   String price,
                   String inventoryQuantity) {
        this.name = name;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
    }

    public static Product of(AddProductDto addProductDto){
        return Product.builder()
                .name(addProductDto.getName())
                .price(addProductDto.getPrice())
                .inventoryQuantity(addProductDto.getInventoryQuantity())
                .build();
    }
}
