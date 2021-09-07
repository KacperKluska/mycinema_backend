package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.studia.Kacper.myCinema.requestBodies.IdBody;
import pl.studia.Kacper.myCinema.requestBodies.TwoIdBody;
import pl.studia.Kacper.myCinema.repositories.WatchLaterRepository;

@RequiredArgsConstructor
@RestController
public class WatchLaterController {
    private final WatchLaterRepository repository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUserWatchLaterFilms")
    public ResponseEntity getAllUserWatchLaterFilms(@RequestBody IdBody responseBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getWatchLaterFilmsByUserId(responseBody.getId())));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteUserWatchLaterFilm")
    public ResponseEntity delteUserWatchLaterFilm(@RequestBody TwoIdBody responseBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.deleteWatchLaterFilmForUser(responseBody.getSecondArgId(), responseBody.getUserId())));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addUserWatchLaterFilm")
    public ResponseEntity addUserWatchLaterFilm(@RequestBody TwoIdBody responseBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.createWatchLaterFilmForUser(responseBody.getSecondArgId(), responseBody.getUserId())));
    }
}
