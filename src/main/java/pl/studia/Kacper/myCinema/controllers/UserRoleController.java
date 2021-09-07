package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.studia.Kacper.myCinema.dao.UserRoleDao;
import pl.studia.Kacper.myCinema.repositories.UserRoleRepository;

@RequiredArgsConstructor
@RestController
public class UserRoleController {
    private final UserRoleRepository repository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUserRoles")
    public ResponseEntity getAllTypes() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(repository.getAllRoles()));
    }
}
