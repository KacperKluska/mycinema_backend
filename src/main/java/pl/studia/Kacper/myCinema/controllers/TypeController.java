package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.studia.Kacper.myCinema.repositories.TypeRepository;

@RequiredArgsConstructor
@RestController
public class TypeController {
    private final TypeRepository repository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getTypes")
    public ResponseEntity getAllTypes() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getAllTypes()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getType")
    public ResponseEntity getType(@RequestParam("typeId") int typeId) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getType(typeId)));
    }
}
