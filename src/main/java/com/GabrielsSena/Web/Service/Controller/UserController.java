package com.GabrielsSena.Web.Service.Controller;

import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/Id")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteByEmail(@RequestParam String email){
        userService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }


}
