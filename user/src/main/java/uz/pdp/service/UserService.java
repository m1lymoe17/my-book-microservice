package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public HttpEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public HttpEntity<?> getUserById(int id) {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    public HttpEntity<?> save(User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    public HttpEntity<?> delete(int id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.ok("Could not delete");
        }
    }
}
