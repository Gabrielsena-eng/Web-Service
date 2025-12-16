package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.Category;
import com.GabrielsSena.Web.Service.Entities.OrderItem;
import com.GabrielsSena.Web.Service.Entities.Product;
import com.GabrielsSena.Web.Service.repository.CategoryRepository;
import com.GabrielsSena.Web.Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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

    public List<Product> findByCategoryId(Long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new RuntimeException("Produtos não encontrados"));
        List<Product> products = productRepository.findAll().stream().
                filter(x -> x.getCategory() == category).toList();

        return products;
    }

    public Product updatePriceById(Long id, Double price){
        Product product = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto não encontrado"));
        product.setPrice(price);
        productRepository.save(product);
        return product;
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
