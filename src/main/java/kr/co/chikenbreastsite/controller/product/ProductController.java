package kr.co.chikenbreastsite.controller.product;

import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.service.product.AddProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final AddProductService addProductService;

    @PostMapping
    public void AddProduct(@RequestBody AddProductDto addProductDto){
        addProductService.addProduct(addProductDto);
    }
}
