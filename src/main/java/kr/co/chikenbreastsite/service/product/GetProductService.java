package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.dto.product.GetProductDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.exception.product.ProductNotFoundException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GetProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
   public GetProductDto getProduct(String ProductCode){
        Product product = productRepository.findByProductCode(ProductCode)
                .orElseThrow(() -> new ProductNotFoundException());

        return Product.of(product);
   }

   //TODO 검색기능을 구현 하려면 쿼리를 써야하는데 쿼리를 공부 후 써야할 지 조언을 구하고 싶음.
}
