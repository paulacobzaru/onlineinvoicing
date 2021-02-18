package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Product;
import com.sda.onlineinvoicing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //TODO method does not exist in ProductService interface
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(new Product());
    }
}
