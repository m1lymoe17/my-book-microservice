package uz.pdp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.entity.Author;
import uz.pdp.entity.Book;
import uz.pdp.repository.AuthorRepository;
import uz.pdp.repository.BookRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        Author alisher_navoiy = authorRepository.save(new Author("Alisher", "Navoiy"));
        Author mirzo_ulugbek = authorRepository.save(new Author("Ulugbek", "Mirzo"));

        List<Author> authorList = new ArrayList<>();
        authorList.add(alisher_navoiy);
        authorList.add(mirzo_ulugbek);

        bookRepository.save(new Book("Dream nigga", "no description", 1, authorList));
        bookRepository.save(new Book("Dream nigga 2", "no description", 2, Collections.singletonList(alisher_navoiy)));
    }
}
