package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(nativeQuery = true,value = "select email from users where id = :userId")
    String getUserEmailByUserId(@Param("userId") Integer userId);
}
