package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.studia.Kacper.myCinema.repositories.FavouriteRepository;
import pl.studia.Kacper.myCinema.requestBodies.IdBody;
import pl.studia.Kacper.myCinema.requestBodies.TwoIdBody;

@RequiredArgsConstructor
@RestController
public class FavouriteController {
    private final FavouriteRepository repository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUserFavouriteFilms")
    public ResponseEntity getAllUserFavouriteFilms(@RequestBody IdBody responseBody) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(repository.getFavouriteFilmsByUserId(responseBody.getId())));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteUserFavouriteFilm")
    public ResponseEntity delteUserFavouriteFilm(@RequestBody TwoIdBody responseBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(
                repository.deleteFavouriteFilmForUser(responseBody.getSecondArgId(), responseBody.getUserId())));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addUserFavouriteFilm")
    public ResponseEntity addUserFavouriteFilm(@RequestBody TwoIdBody responseBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(
                repository.createFavouriteFilmForUser(responseBody.getSecondArgId(), responseBody.getUserId())));
    }
}
