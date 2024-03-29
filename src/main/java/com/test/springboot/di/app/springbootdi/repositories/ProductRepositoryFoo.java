package com.test.springboot.di.app.springbootdi.repositories;

import com.test.springboot.di.app.springbootdi.models.Product;
import com.test.springboot.di.app.springbootdi.repositories.irepository.IProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository("productFoo")
public class ProductRepositoryFoo implements IProductRepository {
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Monitor Asus 27", 600L);
    }
}
