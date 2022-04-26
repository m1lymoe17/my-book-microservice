package uz.pdp.clients.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/api/user")
    List<User> getAllUsers();

    @GetMapping("/api/user/{id}")
    User getUserById(@PathVariable("id") int id);

    @PostMapping("/api/user")
    User save(@RequestBody User user);

    @DeleteMapping("/api/user/{id}")
    String deleteById(@PathVariable("id") int id);

    @GetMapping("/api/user/getUserEmailByUserId/{userId}")
    String getUserEmailByUserId(@PathVariable("userId") Integer userId);
}
