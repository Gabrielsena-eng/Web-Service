package com.GabrielsSena.Web.Service.Repository;

import com.GabrielsSena.Web.Service.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    CategoryRepository findByName(String name);

}
