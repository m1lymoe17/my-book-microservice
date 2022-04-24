package uz.pdp.userfavourite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.userfavourite.dto.UserFavouriteDto;
import uz.pdp.userfavourite.entity.UserFavourite;
import uz.pdp.userfavourite.service.UserFavouriteService;

import java.util.List;

@RestController
@RequestMapping("/api/user-favourite")
public class UserFavouriteController {

    @Autowired
    UserFavouriteService userFavouriteService;

    @GetMapping("/{id}")
    public HttpEntity<?> getAuthorById(@PathVariable int id) {
        List<UserFavourite> userFavouritesByUserId = userFavouriteService.getUserFavouritesByUserId(id);
        return ResponseEntity.ok(userFavouritesByUserId);
    }

    @PostMapping
    public HttpEntity<?> addAndRemoveFromFavourites(@RequestBody UserFavouriteDto userFavouriteDto) {
        return userFavouriteService.addAndRemoveFromFavourites(userFavouriteDto);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable int id) {
        return userFavouriteService.delete(id);
    }
}
