package com.hqgml.service;

import com.hqgml.domian.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll() throws Exception;

    void saveProduct(Product product) throws Exception;
}
