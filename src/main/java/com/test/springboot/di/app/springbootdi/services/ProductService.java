package com.test.springboot.di.app.springbootdi.services;

import com.test.springboot.di.app.springbootdi.models.Product;
import com.test.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.test.springboot.di.app.springbootdi.services.iservices.IProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {
    private ProductRepository repository = new ProductRepository();
    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {  //Buscamo los datos se multiplican por 1.25d y se vuelve a settear el precio como long
            Double priceTax = p.getPrice() * 1.25d;
           /*
           Product newProd = new Product(p.getId(),p.getName(), priceTax.longValue());
            */
            Product newProd = (Product) p.clone();     // Clone tambien es para mantener la inmutabilidad
            newProd.setPrice(priceTax.longValue());
            return newProd;                            // devolvemos el resultado pero se devuelve como un stream, nueva instancia para inmutabilidad
        }).collect(Collectors.toList());               // convertimos el stream a lista porque eso devuelve el metodo
    }

    @Override
    public Product findById (Long id){
        return repository.findById(id);
    }
}
