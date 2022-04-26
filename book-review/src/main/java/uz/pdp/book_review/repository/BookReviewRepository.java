package uz.pdp.book_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.book_review.entity.BookReview;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {
    @Query(nativeQuery = true,value = "select * from book_review where book_id = :bookId")
    List<BookReview> findAllByBookId(@Param("bookId") Integer bookId);
}
