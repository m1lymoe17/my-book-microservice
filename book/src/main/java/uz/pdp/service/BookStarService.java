package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.dto.BookStarDto;
import uz.pdp.entity.Book;
import uz.pdp.entity.BookStar;
import uz.pdp.repository.BookRepository;
import uz.pdp.repository.BookStarRepository;

@Service
public class BookStarService {
    @Autowired
    BookStarRepository bookStarRepository;

    @Autowired
    BookRepository bookRepository;

    public HttpEntity<?> addStartsToBook(BookStarDto bookStarDto) {

        if (bookStarDto.getStars() > 5 || bookStarDto.getStars() < 1) {
            return ResponseEntity.ok("min 1, max 5");
        }

        try {
            Book book = bookRepository.getById(bookStarDto.getBookId());
            if (bookStarDto.getId() != null) {
                BookStar bookStar = bookStarRepository.getById(bookStarDto.getId());
                bookStar.setBook(book);
                bookStar.setStars(bookStar.getStars());
                bookStarRepository.save(bookStar);
            } else {
                bookStarRepository.save(
                        new BookStar(book, bookStarDto.getUserId(),
                                bookStarDto.getStars()));
            }
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.ok("fail");
        }
    }
}
