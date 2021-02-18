package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    //TODO saveproduct method should be in interface
    void saveProduct(Product product);

    void deleteProduct(int productId);

    Product getProductById(int productId);
}
