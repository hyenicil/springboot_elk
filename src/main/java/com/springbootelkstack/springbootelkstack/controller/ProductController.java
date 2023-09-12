package com.springbootelkstack.springbootelkstack.controller;

import com.springbootelkstack.springbootelkstack.entity.Product;
import com.springbootelkstack.springbootelkstack.service.ProductService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private static final Logger logger =  LoggerFactory.getLogger(String.valueOf(ProductController.class));
    @Autowired
    private ProductService productService;


    @GetMapping("/findAll")
    Iterable<Product> findAll(){
        return  productService.getProducts();
    }

    @PostMapping("/insert")
    Product addProduct(@RequestBody Product product) {
        logger.info("Saved " + product.getName());
    return productService.insertProduct(product);
    }

    @DeleteMapping("/{id}")
    void deleteProduct(Integer id){
        logger.info("deleted " );
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    Product updateProduct(Integer id, Product product){
        logger.info("updated " + product.getName());
        return  productService.updateProduct(product, id);
    }
}
