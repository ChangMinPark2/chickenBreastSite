package kr.co.chikenbreastsite.controller.product;

import kr.co.chikenbreastsite.domain.dto.product.AddProductDto;
import kr.co.chikenbreastsite.domain.dto.product.DeleteProductDto;
import kr.co.chikenbreastsite.domain.dto.product.GetProductDto;
import kr.co.chikenbreastsite.domain.dto.product.UpdateProductDto;
import kr.co.chikenbreastsite.exception.ResponseFormat;
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
    public ResponseFormat AddProduct(@RequestBody @Valid AddProductDto addProductDto){
        addProductService.createProduct(addProductDto);
        return ResponseFormat.ok("상품추가가 되었습니다.");
    }

    @GetMapping//해당 상품 가져오기
    public ResponseFormat getProduct(@RequestParam("productName") String productName){
        return ResponseFormat.ok(getProductService.getProduct(productName));
    }

    @DeleteMapping
    public ResponseFormat DeleteProduct(@RequestBody @Valid DeleteProductDto deleteProductDto){
        deleteProductService.DeleteProduct(deleteProductDto);
        return ResponseFormat.ok();
    }

    @PutMapping
    public ResponseFormat updateProduct(@RequestBody @Valid UpdateProductDto updateProductDto){
        updateProductService.updateProduct(updateProductDto);
        return ResponseFormat.ok();
    }
}
