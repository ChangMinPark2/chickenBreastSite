package kr.co.chikenbreastsite.domain.entity.product;


import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.domain.dto.product.GetProductDto;
import kr.co.chikenbreastsite.domain.dto.product.UpdateProductDto;
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
    private int price;

    @Column(name = "inventory_quantity")
    private int inventoryQuantity;   //재고수량

    @Builder
    public Product(String name,
                   int price,
                   int inventoryQuantity) {
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

    public static GetProductDto of(Product product){
        return GetProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .inventoryQuantity(product.getInventoryQuantity())
                .build();
    }

    public void updateProduct(String name,
                              int price) {
        this.name = name;
        this.price = price;
    }

    public void updateInventoryQuantity(int inventoryQuantity){
        this.inventoryQuantity += inventoryQuantity;
    }
}
