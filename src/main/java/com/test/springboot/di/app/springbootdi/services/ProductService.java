package com.test.springboot.di.app.springbootdi.services;

import com.test.springboot.di.app.springbootdi.models.Product;
import com.test.springboot.di.app.springbootdi.repositories.irepository.IProductRepository;
import com.test.springboot.di.app.springbootdi.services.iservices.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private Environment environment;
    //@Autowired
    //@Qualifier("productList")
    private IProductRepository repository;

   public ProductService(@Qualifier("productJson") IProductRepository repository) { // Tambien se puede inyectar mediante construccion y no sera necesario el Autowired
        this.repository = repository;
   }
    //public ProductService(IProductRepository repository) { // Tambien se puede inyectar mediante construccion y no sera necesario el Autowired
    //    this.repository = repository;
    //}
    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {  //Buscamo los datos se multiplican por 1.25d y se vuelve a settear el precio como long
           // Double priceTax = p.getPrice() * 1.25d;
            Double priceTax = p.getPrice() * environment.getProperty("config.taxValue",Double.class);;
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
