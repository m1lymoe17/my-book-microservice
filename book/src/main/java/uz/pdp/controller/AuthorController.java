package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity.Author;
import uz.pdp.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public HttpEntity<?> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public HttpEntity<?> getAuthorById(@PathVariable("authorId") int id) {
        return authorService.getAuthorsById(id);
    }

    @PostMapping
    public HttpEntity<?> save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAuthorById(@PathVariable int id) {
        return authorService.delete(id);
    }
}
