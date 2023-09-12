package com.springbootelkstack.springbootelkstack.service;

import com.springbootelkstack.springbootelkstack.entity.Product;
import com.springbootelkstack.springbootelkstack.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private  ProductRepo productRepository;

    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProducts(){
       return productRepository.findAll();
    }

    public Product insertProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct(Product product,Integer id){
        Product product1 = productRepository.findById(id).get();
        product1.setId(product.getId());
        return product1;
    }

    public void deleteProduct(Integer id ){
        productRepository.deleteById(id);
    }
}
