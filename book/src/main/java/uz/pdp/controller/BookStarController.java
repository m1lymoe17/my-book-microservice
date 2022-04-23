package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.dto.BookStarDto;
import uz.pdp.service.BookStarService;

@RestController
@RequestMapping("/api/book_star")
public class BookStarController {
    @Autowired
    BookStarService bookStarService;

    @PostMapping
    public HttpEntity<?> addStarsToBook(@RequestBody BookStarDto bookStarDto) {
        return bookStarService.addStartsToBook(bookStarDto);
    }
}
