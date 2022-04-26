package uz.pdp.clients.bookReview;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "book-review")
public interface BookReviewClient {

    @GetMapping("/api/book-review")
    List<BookReview> getAllBookReviews();

    @GetMapping("/api/book-review/{id}")
    BookReview getBookReviewById(@PathVariable("id") int id);

    @PostMapping("/api/book-review")
    BookReview save(@RequestBody BookReview bookReview);

    @DeleteMapping("/api/book-review/{id}")
    String deleteBookReviewById(@PathVariable("id") int id);
}
