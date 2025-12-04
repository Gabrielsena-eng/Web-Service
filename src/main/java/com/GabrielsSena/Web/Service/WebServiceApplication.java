package com.GabrielsSena.Web.Service;

import com.GabrielsSena.Web.Service.Controller.UserController;
import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.repository.UserRepository;
import com.GabrielsSena.Web.Service.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);

	}

}
