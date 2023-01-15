package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.exception.product.DuplicationProductCodeException;
import kr.co.chikenbreastsite.exception.product.DuplicationProductNameException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AddProductService {

    private final ProductRepository productRepository;

    public void addProduct(AddProductDto addProductdto){

        CheckProductCode(addProductdto.getProductCode());
        CheckProductName(addProductdto.getName()); // -> 상품이름은 같으면 안 되니까 체크
        // 상품을 추가하면 재고수량 + 1 이 되는기능을 어떻게 해야할지 감이 안 잡혀서 조언을 구하고 싶음.

        final Product productBuild = Product.of(addProductdto);
        productRepository.save(productBuild);
    }

    private void CheckProductCode(String ProductCode){
        if(productRepository.existsByProductIdentity(ProductCode))
            throw new DuplicationProductCodeException();
    }

    private void CheckProductName(String ProductName){
        if(productRepository.existsByName(ProductName))
            throw new DuplicationProductNameException();
    }
}
