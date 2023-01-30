package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.dto.product.DeleteProductDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.domain.entity.product.UserRole;
import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.product.ProductDoesNotAlreadyExistException;
import kr.co.chikenbreastsite.exception.product.ProductNotFoundException;
import kr.co.chikenbreastsite.exception.users.DuplicationCellPhoneException;
import kr.co.chikenbreastsite.exception.users.UsersNotRoleException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductService {

    private final ProductRepository productRepository;

    public void deleteProduct(DeleteProductDto deleteProductDto){
        Product product = productRepository.findByName(deleteProductDto.getName())
                .orElseThrow(() -> new ProductDoesNotAlreadyExistException());
        roleCheck(deleteProductDto.getUserRole());
        productRepository.delete(product);

    }

    private void roleCheck(String role){
        if(!role.equals("ROLE_ADMIN")) throw new UsersNotRoleException();
    }
}
