package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.dto.product.UpdateProductDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.exception.product.DuplicationProductCodeException;
import kr.co.chikenbreastsite.exception.product.DuplicationProductNameException;
import kr.co.chikenbreastsite.exception.product.ProductNotFoundException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductService {
    private final ProductRepository productRepository;

    public void updateProduct(UpdateProductDto updateProductDto){
        Product product = productRepository.findByProductCode(updateProductDto.getProductCode())
                .orElseThrow(() -> new ProductNotFoundException());

        CheckProductCode(updateProductDto.getProductCode());
        CheckName(updateProductDto.getName());

        product.updateProduct(updateProductDto.getName(), updateProductDto.getPrice());

        productRepository.save(product);
    }

    private void CheckProductCode(String productCode){
        if(productRepository.existsByProductIdentity(productCode))
            throw new DuplicationProductCodeException();
    }

    private void CheckName(String name){
        if(productRepository.existsByName(name))
            throw new DuplicationProductNameException();
    }
}
