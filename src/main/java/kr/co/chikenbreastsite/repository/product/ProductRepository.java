package kr.co.chikenbreastsite.repository.product;

import kr.co.chikenbreastsite.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductCode(String productCode);
    Boolean existsByProductIdentity(String identity);
    Boolean existsByName(String name);
}
