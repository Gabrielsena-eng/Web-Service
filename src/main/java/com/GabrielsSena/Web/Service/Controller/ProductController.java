package com.GabrielsSena.Web.Service.Controller;

import com.GabrielsSena.Web.Service.Entities.Category;
import com.GabrielsSena.Web.Service.Entities.Product;
import com.GabrielsSena.Web.Service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> findByCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(productService.findByCategoryId(id));
    }

    @GetMapping(params = "name")
    public ResponseEntity<Product> findByName(@RequestParam String name){
        return ResponseEntity.ok(productService.findByName(name));
    }

    @GetMapping(params = {"initialValue", "finalValue"})
    public ResponseEntity<List<Product>> findByPriceBetween(
            @RequestParam Double initialValue,
            @RequestParam Double finalValue
    ){
        return ResponseEntity.ok(productService.findByPriceBetween(initialValue, finalValue));
    }

    @PutMapping
    public ResponseEntity<Product> UpdatePriceById(Long id, Double price){
        productService.updatePriceById(id, price);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
