package com.GabrielsSena.Web.Service.Controller;

import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "gajdgsd", "8t358", "q499324");
        return ResponseEntity.ok().body(u);
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
