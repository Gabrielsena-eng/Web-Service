package com.GabrielsSena.Web.Service.Repository;

import com.GabrielsSena.Web.Service.Entities.Category;
import com.GabrielsSena.Web.Service.Entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetween(Double initialValue, Double finalValue);
    Product findByName(String name);


    @Transactional
    void deleteByName(String name);


}
