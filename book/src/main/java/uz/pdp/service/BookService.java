package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Book;
import uz.pdp.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public HttpEntity getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    public HttpEntity getBooksById(int id) {
        return ResponseEntity.ok(bookRepository.findById(id));
    }

    public HttpEntity save(Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }

    public HttpEntity delete(int id) {
        try {
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.ok("Could not delete");
        }
    }
}
