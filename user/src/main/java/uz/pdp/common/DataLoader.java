package uz.pdp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.clients.book.BookClient;
import uz.pdp.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookClient bookClient;

    @Override
    public void run(String... args) throws Exception {
//        userRepository.save(new User("Umidjon","Muydinov","m1lmyoe","12345",bookClient.getBookById(1)));
    }
}
