package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.clients.bookAndAuthor.Book;
import uz.pdp.dto.BookStarDto;
import uz.pdp.service.BookService;
import uz.pdp.service.BookStarService;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookStarService bookStarService;

    @GetMapping
    public HttpEntity<?> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public HttpEntity<?> getBookById (@PathVariable("bookId") int bookId){
        return bookService.getBooksById(bookId);
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{bookId}")
    public HttpEntity<?> deleteBookById(@PathVariable("bookId") int id) {
        return bookService.delete(id);
    }

    @PostMapping("/addStar")
    public HttpEntity<?> addStarsToBook(@RequestBody BookStarDto bookStarDto) {
        return bookStarService.addStartsToBook(bookStarDto);
    }
}
