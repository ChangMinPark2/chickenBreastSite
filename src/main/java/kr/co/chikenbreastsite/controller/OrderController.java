package kr.co.chikenbreastsite.controller;

import kr.co.chikenbreastsite.domain.dto.order.CreateOrderDto;
import kr.co.chikenbreastsite.domain.dto.order.ReadOrderDto;
import kr.co.chikenbreastsite.exception.ResponseFormat;
import kr.co.chikenbreastsite.service.order.CreateOrderService;
import kr.co.chikenbreastsite.service.order.ReadOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

   private final CreateOrderService createOrderService;

   private final ReadOrderService readOrderService;
   @PostMapping
    public ResponseFormat createOrder(@RequestBody @Valid CreateOrderDto createOrderDto){
       createOrderService.createOrder(createOrderDto);
       return ResponseFormat.ok("상품이 주문되었습니다.");
   }

   @GetMapping
   public ResponseFormat<List<ReadOrderDto>> readOrderDto(@RequestParam("identity") String identity){
      return ResponseFormat.ok(readOrderService.readOrderDto(identity));
   }
}
