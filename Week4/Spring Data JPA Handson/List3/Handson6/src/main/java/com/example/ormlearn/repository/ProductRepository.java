package com.example.ormlearn.repository;

import com.example.ormlearn.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {}
