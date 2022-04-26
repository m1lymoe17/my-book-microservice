package uz.pdp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User umidjon = userRepository.save(
                new User("Umidjon",
                        "Muydinov",
                        "m1lmyoe16@gmail.com",
                        "12345"));

        User hoji = userRepository.save(
                new User(
                        "Hojiakbar",
                        "Muydinov",
                        "hoji17@gmail.com",
                        "12345"));
    }
}
