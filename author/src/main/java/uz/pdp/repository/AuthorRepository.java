package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
