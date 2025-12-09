package com.GabrielsSena.Web.Service;

import com.GabrielsSena.Web.Service.Entities.Category;
import com.GabrielsSena.Web.Service.Entities.Product;
import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Repository.CategoryRepository;
import com.GabrielsSena.Web.Service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TestConfig(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", cat1);
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "", cat2);
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", cat3);
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", cat2);
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "", cat3);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
