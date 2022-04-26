package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.clients.bookAndAuthor.Book;
import uz.pdp.entity.Author;
import uz.pdp.repository.AuthorRepository;
import uz.pdp.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public HttpEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    public HttpEntity<?> getBooksById(int id) {
        return ResponseEntity.ok(bookRepository.findById(id).get());
    }

    public HttpEntity<?> save(Book book) {
        try {
            List<Author> authorList = new ArrayList<>();

            for (Integer integer : book.getAuthorId()) {
                Author author = authorRepository.getById(integer);
                authorList.add(author);
            }

            if (book.getId() != null) {
                uz.pdp.entity.Book book1 = bookRepository.getById(book.getId());
                book1.setTitle(book.getTitle());
                book1.setDescription(book.getDescription());
                book1.setAuthorList(authorList);
                bookRepository.save(book1);
            } else {
                bookRepository.save(new uz.pdp.entity.Book(book.getTitle(), book.getDescription(), book.getCurrentUserId(),
                        authorList));
            }
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.ok("fail");
        }
    }

    public HttpEntity<?> delete(int id) {
        try {
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.ok("Could not delete");
        }
    }
}
