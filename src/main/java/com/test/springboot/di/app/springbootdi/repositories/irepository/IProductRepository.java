package com.test.springboot.di.app.springbootdi.repositories.irepository;

import com.test.springboot.di.app.springbootdi.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
