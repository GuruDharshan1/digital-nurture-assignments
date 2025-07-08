package com.example.ormlearn;

import com.example.ormlearn.model.Product;
import com.example.ormlearn.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductService productService) {
        return args -> {
            List<Product> products = productService.searchProducts("laptop", 16, "Windows 11", 2.5, "Intel", 2.5, 4.0);
            products.forEach(System.out::println);
        };
    }
}
