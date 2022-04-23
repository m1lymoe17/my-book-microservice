package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.BookStar;

public interface BookStarRepository extends JpaRepository<BookStar,Integer> {
}
