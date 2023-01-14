package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.exception.product.DuplicationProductIdException;
import kr.co.chikenbreastsite.exception.product.DuplicationProductNameException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class AddProductService {

    private final ProductRepository productRepository;

    public void addProduct(AddProductDto addProductdto){

        CheckProductIdentity(addProductdto.getProductIdentity());
        CheckProductName(addProductdto.getName()); // -> 상품이름은 같으면 안 되니까 체크
        // 상품을 추가하면 재고수량 + 1 이 되는기능을 어떻게 해야할지 감이 안 잡혀서 조언을 구하고 싶음.

        final Product productBuild = Product.of(addProductdto);
        productRepository.save(productBuild);
    }

    private void CheckProductIdentity(String ProductIdentity){
        if(productRepository.existsByProductIdentity(ProductIdentity))
            throw new DuplicationProductIdException(); //TODO : 이 경우 CheckProductIdentity보다 CheckProductNumbur가 맞는지 조언을 구하고 싶음
    }

    private void CheckProductName(String ProductName){
        if(productRepository.existsByName(ProductName))
            throw new DuplicationProductNameException();
    }
}
