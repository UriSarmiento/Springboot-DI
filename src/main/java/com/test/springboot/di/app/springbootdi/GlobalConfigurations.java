package com.test.springboot.di.app.springbootdi;

import com.test.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import com.test.springboot.di.app.springbootdi.repositories.irepository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:globalConfigurations.properties", encoding = "UTF-8")
})
public class GlobalConfigurations {
    @Value("classpath:json/product.json")
    private Resource resource;
    @Bean("productJson") //Otra forma de crear un componente Spring
    IProductRepository productRepositoryJson(){
        return new ProductRepositoryJson(resource);
    }

}
