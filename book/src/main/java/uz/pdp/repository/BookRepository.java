package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
