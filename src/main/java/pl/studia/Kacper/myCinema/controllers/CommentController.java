package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.studia.Kacper.myCinema.requestBodies.CommentBody;
import pl.studia.Kacper.myCinema.requestBodies.IdBody;
import pl.studia.Kacper.myCinema.repositories.CommentRepository;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository repository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllFilmComments")
    public ResponseEntity getAllFilmComments(@RequestParam("filmId") int filmId) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getFilmComments(filmId)));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllComments")
    public ResponseEntity getAllComments() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getAllComments()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addNewCommentToFilm")
    public ResponseEntity addNewComment(@RequestBody CommentBody requestBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.createComment(requestBody.getText(), requestBody.getUserRate(), requestBody.getFilmId(), requestBody.getUserId())));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteComment")
    public ResponseEntity deleteComment(@RequestBody IdBody requestBody) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.deleteComment(requestBody.getId())));
    }
}
