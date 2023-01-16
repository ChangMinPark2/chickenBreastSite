package kr.co.chikenbreastsite.controller.product;

import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.domain.dto.product.GetProductDto;
import kr.co.chikenbreastsite.domain.dto.product.UpdateProductDto;
import kr.co.chikenbreastsite.service.product.AddProductService;
import kr.co.chikenbreastsite.service.product.DeleteProductService;
import kr.co.chikenbreastsite.service.product.GetProductService;
import kr.co.chikenbreastsite.service.product.UpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final AddProductService addProductService;

    private final GetProductService getProductService;

    private final DeleteProductService deleteProductService;

    private final UpdateProductService updateProductService;
    @PostMapping//상품 추가, 이름이 같으면 재고수량 증가
    public void AddProduct(@RequestBody @Valid AddProductDto addProductDto){
        addProductService.createProduct(addProductDto);
    }

    @GetMapping//해당 상품 가져오기
    public GetProductDto getProduct(@RequestParam("productName") String productName){
        return getProductService.getProduct(productName);
    }

    @DeleteMapping
    public void DeleteProduct(@RequestParam("productName") String productName){
        deleteProductService.DeleteProduct(productName);
    }

    @PutMapping
    public void updateProduct(@RequestBody @Valid UpdateProductDto updateProductDto){
        updateProductService.updateProduct(updateProductDto);
    }
}
