package com.test.springboot.di.app.springbootdi.repositories;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springboot.di.app.springbootdi.models.Product;
import com.test.springboot.di.app.springbootdi.repositories.irepository.IProductRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements IProductRepository {
    private List<Product> list;
    public ProductRepositoryJson(Resource resource) {
        readJson(resource);
    }

    private void readJson(Resource resource){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // list = Arrays.asList(objectMapper.readValue(resource.getFile(),Product[].class));
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(),Product[].class));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter( p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
