package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity.Book;
import uz.pdp.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public HttpEntity getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public HttpEntity getBookById(@PathVariable int id){
        return bookService.getBooksById(id);
    }

    @PostMapping
    public HttpEntity save(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public HttpEntity deleteById(@PathVariable int id){
        return bookService.delete(id);
    }
}
