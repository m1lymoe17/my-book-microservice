package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
