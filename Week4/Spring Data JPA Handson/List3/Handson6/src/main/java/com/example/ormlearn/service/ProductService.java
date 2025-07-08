package com.example.ormlearn.service;

import com.example.ormlearn.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchProducts(String keyword, Integer ramSize, String os, Double minCpuSpeed,
                                        String cpu, Double maxWeight, Double minRating) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (keyword != null && !keyword.isEmpty()) {
            predicates.add(cb.like(cb.lower(product.get("name")), "%" + keyword.toLowerCase() + "%"));
        }
        if (ramSize != null) {
            predicates.add(cb.equal(product.get("ramSize"), ramSize));
        }
        if (os != null && !os.isEmpty()) {
            predicates.add(cb.equal(product.get("os"), os));
        }
        if (minCpuSpeed != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("cpuSpeed"), minCpuSpeed));
        }
        if (cpu != null && !cpu.isEmpty()) {
            predicates.add(cb.equal(product.get("cpu"), cpu));
        }
        if (maxWeight != null) {
            predicates.add(cb.lessThanOrEqualTo(product.get("weight"), maxWeight));
        }
        if (minRating != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("rating"), minRating));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
