package kr.co.chikenbreastsite.controller.product;

import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.domain.dto.product.GetProductDto;
import kr.co.chikenbreastsite.service.product.AddProductService;
import kr.co.chikenbreastsite.service.product.GetProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final AddProductService addProductService;

    private final GetProductService getProductService;

    @PostMapping
    public void AddProduct(@RequestBody AddProductDto addProductDto){
        addProductService.addProduct(addProductDto);
    }

    @GetMapping//해당 번호 상품 가져오기기능
    public GetProductDto getProduct(@RequestParam("ProductIdentity") String ProductIdentity){
        return getProductService.getProduct(ProductIdentity);
    }

   // public
}
