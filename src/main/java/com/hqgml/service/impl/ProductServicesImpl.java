package com.hqgml.service.impl;

import com.hqgml.dao.IProductDao;
import com.hqgml.domian.Product;
import com.hqgml.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @data 11/14/2019 7:22 PM
 **/
@Service
//居于注解的事物控制
@Transactional
public class ProductServicesImpl implements ProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }
}
