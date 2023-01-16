package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.exception.product.ProductDoesNotAlreadyExistException;
import kr.co.chikenbreastsite.exception.product.ProductNotFoundException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductService {

    private final ProductRepository productRepository;

    public void DeleteProduct(String productName){
        Product product = productRepository.findByName(productName)
                .orElseThrow(() -> new ProductDoesNotAlreadyExistException());

        productRepository.delete(product);
    }
}
