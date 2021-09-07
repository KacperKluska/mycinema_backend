package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.studia.Kacper.myCinema.requestBodies.FilmBody;
import pl.studia.Kacper.myCinema.requestBodies.IdBody;
import pl.studia.Kacper.myCinema.repositories.FilmRepository;

@RequiredArgsConstructor
@RestController
public class FilmController {
    private final FilmRepository repository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllFilms")
    public ResponseEntity getAllFilms(@RequestParam("page") int page, @RequestParam("q") String query) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getAllFilms(page, query)));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getFilm")
    public ResponseEntity getFilm(@RequestParam("filmId") int filmId) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getFilm(filmId)));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addFilm")
    public ResponseEntity addFilm(@RequestBody FilmBody requestBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.createFilm(requestBody)));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteFilm")
    public ResponseEntity deleteFilm(@RequestBody IdBody requestBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.deleteFilm(requestBody.getId())));
    }
}
