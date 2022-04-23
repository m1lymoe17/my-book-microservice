package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Author;
import uz.pdp.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public HttpEntity<?> getAllAuthors() {
        return ResponseEntity.ok(authorRepository.findAll());
    }

    public HttpEntity<?> getAuthorsById(int id) {
        return ResponseEntity.ok(authorRepository.findById(id));
    }

    public HttpEntity<?> save(Author author) {
        return ResponseEntity.ok(authorRepository.save(author));
    }

    public HttpEntity<?> delete(int id) {
        try {
            authorRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.ok("Could not delete");
        }
    }
}
