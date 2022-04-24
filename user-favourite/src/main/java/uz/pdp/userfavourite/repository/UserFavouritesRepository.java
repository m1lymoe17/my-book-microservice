package uz.pdp.userfavourite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.userfavourite.entity.UserFavourite;

import java.util.List;

public interface UserFavouritesRepository extends JpaRepository<UserFavourite, Integer> {
    List<UserFavourite> getUserFavouriteByUserId(Integer id);
}
