package kr.co.chikenbreastsite.service.order;

import kr.co.chikenbreastsite.domain.dto.order.CreateOrderDto;
import kr.co.chikenbreastsite.domain.entity.order.Order;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.order.ProductDoesNotHaveException;
import kr.co.chikenbreastsite.exception.product.ProductNotFoundException;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.OrderRepository;
import kr.co.chikenbreastsite.repository.ProductRepository;
import kr.co.chikenbreastsite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateOrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final UsersRepository usersRepository;

    public void createOrder(CreateOrderDto createOrderDto){
        Users users = usersRepository.findByIdentity(createOrderDto.getIdentity())
                .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), createOrderDto.getPassword());

        Product product = productRepository.findByName(createOrderDto.getProducts())
                .orElseThrow(() -> new ProductNotFoundException());

        updateInventoryQuantity(product.getInventoryQuantity(), createOrderDto.getNumberOfProducts(), product);

        LocalDate nowDate = LocalDate.now(); //현재 날짜

        orderRepository.save(Order.of(createOrderDto, nowDate, users,
                product, product.getPrice() * createOrderDto.getNumberOfProducts()));
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }

    private void updateInventoryQuantity(int productInventoryQuantity,
                                         int numberofProduct, Product product){
        if(productInventoryQuantity > 0){
            product.orderinven(product.getInventoryQuantity() - numberofProduct);
            productRepository.save(product);
        }
        else
            throw new ProductDoesNotHaveException();
    }
}
