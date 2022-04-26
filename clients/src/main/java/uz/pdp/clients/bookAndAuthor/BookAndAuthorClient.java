package uz.pdp.clients.bookAndAuthor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "book")
public interface BookAndAuthorClient {

    @GetMapping("/api/book")
    List<Book> getAllBooks();

    @GetMapping("/api/book/{bookId}")
    Book getBookById(@PathVariable("bookId") int bookId);

    @PostMapping("/api/book")
    Book save(@RequestBody Book book);

    @DeleteMapping("/api/book/{id}")
    String deleteBookById(@PathVariable("id") int id);

    @DeleteMapping("/api/author/{id}")
    String deleteAuthorById(@PathVariable("id") int id);

    @PostMapping("/api/book/addStar")
    String addStarsToBook(@RequestBody BookStar bookStar);

    @GetMapping("/api/author")
    List<Author> getAllAuthors();

    @GetMapping("/api/author/{id}")
    Author getAuthorById(@PathVariable("id") int id);

    @PostMapping("/api/author")
    Author save(@RequestBody Author author);
}
