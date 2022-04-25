package uz.pdp.book_review.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.book_review.entity.BookReview;
import uz.pdp.book_review.repository.BookReviewRepository;

@Service
public class BookReviewService {

    @Autowired
    BookReviewRepository bookReviewRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    String exchange;

    @Value("${spring.rabbitmq.routing-key}")
    String routingKey;

    public HttpEntity<?> getAllBookReviews() {
        return ResponseEntity.ok(bookReviewRepository.findAll());
    }

    public HttpEntity<?> getBookReviewById(int id) {
        return ResponseEntity.ok(bookReviewRepository.findById(id).get());
    }

    public HttpEntity<?> save(BookReview bookReview) {
        rabbitTemplate.convertAndSend(exchange, routingKey, bookReview);
        return ResponseEntity.ok(bookReviewRepository.save(bookReview));
    }

    public HttpEntity<?> delete(int id) {
        try {
            bookReviewRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.ok("Could not delete");
        }
    }
}
