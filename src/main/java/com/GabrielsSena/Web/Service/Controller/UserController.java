package com.GabrielsSena.Web.Service.Controller;

import com.GabrielsSena.Web.Service.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "gajdgsd", "8t358", "q499324");
        return ResponseEntity.ok().body(u);
    }
}
