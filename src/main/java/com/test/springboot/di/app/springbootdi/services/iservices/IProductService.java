package com.test.springboot.di.app.springbootdi.services.iservices;

import com.test.springboot.di.app.springbootdi.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);

}
