package uz.pdp.book_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.book_review.entity.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {
}
