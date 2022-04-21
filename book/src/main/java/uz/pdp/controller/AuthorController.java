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
    public HttpEntity getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public HttpEntity getAuthorById(@PathVariable int id){
        return authorService.getAuthorsById(id);
    }

    @PostMapping
    public HttpEntity save(@RequestBody Author book){
        return authorService.save(book);
    }

    @DeleteMapping("/{id}")
    public HttpEntity deleteById(@PathVariable int id){
        return authorService.delete(id);
    }
}
