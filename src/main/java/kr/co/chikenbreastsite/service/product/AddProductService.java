package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.exception.product.DuplicationProductNameException;
import kr.co.chikenbreastsite.exception.product.ProductNotFoundException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AddProductService {

    private final ProductRepository productRepository;

    public void createProduct(AddProductDto addProductDto){
        checkProductNameAndCreate(addProductDto);
    }


    private void addProduct(AddProductDto addProductDto){
        Product product = productRepository.findByName(addProductDto.getName())
                .orElseThrow(() -> new ProductNotFoundException());

        product.updateInventoryQuantity(addProductDto.getInventoryQuantity());
        productRepository.save(product);
    }

    private void checkProductNameAndCreate(AddProductDto addProductDto){
        if(!productRepository.existsByName(addProductDto.getName())){
            productRepository.save(Product.of(addProductDto));
        }else{
            addProduct(addProductDto);
        }
    }
}
