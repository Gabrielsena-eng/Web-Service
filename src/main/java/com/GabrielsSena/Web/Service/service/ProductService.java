package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.Category;
import com.GabrielsSena.Web.Service.Entities.OrderItem;
import com.GabrielsSena.Web.Service.Entities.Product;
import com.GabrielsSena.Web.Service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
    }

    public Product findByName(String name){
        return productRepository.findByName(name);
    }

    public List<Product> findByPriceBetween(Double initialValue, Double finalValue){
        return productRepository.findByPriceBetween(initialValue, finalValue);
    }

    public List<Product> findByCategory(Category category){
        return productRepository.findByCategory(category);
    }


}
