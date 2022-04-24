package uz.pdp.userfavourite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.clients.book.BookClient;
import uz.pdp.clients.user.UserClient;
import uz.pdp.userfavourite.dto.UserFavouriteDto;
import uz.pdp.userfavourite.entity.UserFavourite;
import uz.pdp.userfavourite.repository.UserFavouritesRepository;

import java.util.List;

@Service
public class UserFavouriteService {

    @Autowired
    UserClient userClient;

    @Autowired
    BookClient bookClient;

    @Autowired
    UserFavouritesRepository userFavouritesRepository;

    public List<UserFavourite> getUserFavouritesByUserId(int id) {
        return userFavouritesRepository.getUserFavouriteByUserId(id);
    }

    public HttpEntity<?> delete(int id) {
        try {
            userFavouritesRepository.deleteById(id);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.ok("fail");
        }
    }

    public HttpEntity<?> addAndRemoveFromFavourites(UserFavouriteDto userFavouriteDto) {
        if (userFavouriteDto.getId() != null) {
            delete(userFavouriteDto.getId());
            return ResponseEntity.ok("removed from favourites");
        } else {
            userFavouritesRepository.save(new UserFavourite(userFavouriteDto.getUserId(), userFavouriteDto.getBookId()));
            return ResponseEntity.ok("added to favourites");
        }
    }
}
