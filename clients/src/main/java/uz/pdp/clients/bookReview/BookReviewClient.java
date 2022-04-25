package uz.pdp.clients.bookReview;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "book-review")
public interface BookReviewClient {

    @GetMapping
    List<BookReview> getAllBookReviews();

    @GetMapping("/{id}")
    BookReview getBookReviewById(@PathVariable("id") int id);

    @PostMapping
    BookReview save(@RequestBody BookReview bookReview);

    @DeleteMapping("/{id}")
    String deleteBookReviewById(@PathVariable("id") int id);
}
