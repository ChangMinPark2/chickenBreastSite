package kr.co.chikenbreastsite.repository;

import kr.co.chikenbreastsite.domain.entity.order.Order;
import kr.co.chikenbreastsite.domain.entity.product.Product;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUsers(Users users);
}
