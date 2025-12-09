package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.Category;
import com.GabrielsSena.Web.Service.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada"));
    }

    public Category findByName(String name){
        return categoryRepository.findByName(name);
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

}
