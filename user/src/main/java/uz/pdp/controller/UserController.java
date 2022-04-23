package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity.User;
import uz.pdp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public HttpEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public HttpEntity<?> getBookById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable int id) {
        return userService.delete(id);
    }
}
