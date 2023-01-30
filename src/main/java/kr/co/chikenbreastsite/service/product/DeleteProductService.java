package kr.co.chikenbreastsite.service.product;

import kr.co.chikenbreastsite.domain.dto.product.DeleteProductDto;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.domain.entity.product.UserRole;
import kr.co.chikenbreastsite.exception.product.ProductDoesNotAlreadyExistException;
import kr.co.chikenbreastsite.exception.product.ProductNotFoundException;
import kr.co.chikenbreastsite.exception.users.DuplicationCellPhoneException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductService {

    private final ProductRepository productRepository;

    public void DeleteProduct(DeleteProductDto deleteProductDto){
        Product product = productRepository.findByName(deleteProductDto.getName())
                .orElseThrow(() -> new ProductDoesNotAlreadyExistException());

       /* TODO if(deleteProductDto.getUserRole().equals("ROLE_ADMIN")){
        productRepository.delete(product)
        원래는 deleteDto에 userRole -> String형으로 넣어두고 구현한 메소드인데 이렇게 하면 enum으로
        작성한 의미가 없고, 그냥 관리자가 아닌, 스트링 ROLE_ADMIN인 것 같아서
        아래 메소드를 deleteDto에서 private UserRole userRole로 바꿔서 구현한건데,
        이게 맞는지, 아니면 다른 방법이 있는지 궁금합니다.
        */
        if (deleteProductDto.getUserRole().equals(UserRole.valueOf("ROLE_ADMIN"))){
            productRepository.delete(product);
        }
    }
}
