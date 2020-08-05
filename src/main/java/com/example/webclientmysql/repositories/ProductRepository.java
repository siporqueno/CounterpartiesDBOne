package com.example.webclientmysql.repositories;

import com.example.webclientmysql.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByProductFullName(String productFullName);
    List<Product> findByProductShortNameOrProductFullName(String productShortName,String productFullName);
    List<Product> findByProductShortNameAndProductFullName(String productShortName,String productFullName);
}
