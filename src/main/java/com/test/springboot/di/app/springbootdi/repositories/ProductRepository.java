package com.test.springboot.di.app.springbootdi.repositories;

import com.test.springboot.di.app.springbootdi.models.Product;
import com.test.springboot.di.app.springbootdi.repositories.irepository.IProductRespository;

import java.util.Arrays;
import java.util.List;

public class ProductRepository implements IProductRespository {
    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L,"Memoria Corsair 32",129L), // Para el tipo Long se le pone una L
                new Product(2L,"CPU Intel Core I9",938L),
                new Product(3L,"Teclado Ryzer Mini",240L),
                new Product(4L,"MotherBoard GigaBite",458L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(
                p -> p.getId().equals(id) //expresion lambda
        ).findFirst().orElse(null); // Busca por Id y si no se encuentra devuelve un null
        /*
        return data.stream().filter(
                p -> p.getId().equals(id)
        ).findFirst().orElseThrow(); // Busca por Id y si no se encuentra devuelve una excepcion

         */

    }
}
