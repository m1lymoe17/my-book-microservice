package uz.pdp.clients.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping
    List<User> getAllUsers();

    @GetMapping("/{id}")
    User getUserById(@PathVariable int id);

    @PostMapping
    User save(@RequestBody User user);

    @DeleteMapping("/{id}")
    String deleteById(@PathVariable int id);
}
