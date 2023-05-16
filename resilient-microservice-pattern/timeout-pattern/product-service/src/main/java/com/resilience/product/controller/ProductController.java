package com.resilience.product.controller;

import com.resilience.dto.ProductDto;
import com.resilience.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("{productId}")
    public CompletionStage<ProductDto> getProduct(@PathVariable int productId){
        return this.productService.getProductDto(productId);
    }

    @GetMapping("async/{productId}")
    public ProductDto getProductAsync(@PathVariable int productId){
        return this.productService.getProductDtoAsync(productId);
    }
    
    @GetMapping("/test")
    @Transactional(timeout = 120)
    public String test() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(10, 5000));
        return "Test";
    }
    
}