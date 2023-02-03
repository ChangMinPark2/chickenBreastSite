package kr.co.chikenbreastsite.service.order;

import kr.co.chikenbreastsite.domain.dto.order.ReadOrderDto;
import kr.co.chikenbreastsite.domain.entity.order.Order;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.UsersNotRoleException;
import kr.co.chikenbreastsite.repository.OrderRepository;
import kr.co.chikenbreastsite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReadOrderService {

    private final OrderRepository orderRepository;

    private final UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public List<ReadOrderDto> readOrderDto(String identity){

        Users users = usersRepository.findByIdentity(identity)
                .orElseThrow(() -> new UsersNotRoleException());

        List<Order> orders = orderRepository.findByUsers(users);

        ArrayList<ReadOrderDto> readOrderDtos = new ArrayList<>();

        for(Order order : orders){
            readOrderDtos.add(Order.of(order));
        }
        return readOrderDtos;
    }
}
