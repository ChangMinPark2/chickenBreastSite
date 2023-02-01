package kr.co.chikenbreastsite.controller;

import kr.co.chikenbreastsite.domain.dto.order.CreateOrderDto;
import kr.co.chikenbreastsite.exception.ResponseFormat;
import kr.co.chikenbreastsite.service.order.CreateOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

   private final CreateOrderService createOrderService;

   @PostMapping
    public ResponseFormat createOrder(@RequestBody @Valid CreateOrderDto createOrderDto){
       createOrderService.createOrder(createOrderDto);
       return ResponseFormat.ok("상품이 주문되었습니다.");
   }
}
