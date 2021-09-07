package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import pl.studia.Kacper.myCinema.configuration.MyUserDetails;
import pl.studia.Kacper.myCinema.repositories.UserTableRepository;
import pl.studia.Kacper.myCinema.requestBodies.IdBody;
import pl.studia.Kacper.myCinema.dao.UserTableDao;
import pl.studia.Kacper.myCinema.requestBodies.UserBody;

@RequiredArgsConstructor
@RestController
public class UserTableController {
    private final UserTableDao userTableDao;
    private final UserTableRepository userRepository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUsers")
    public ResponseEntity getAllUsers() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(userTableDao.findAllByRole(1)));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/users")
    public String deleteUser(@RequestBody IdBody body/*@AuthenticationPrincipal MyUserDetails user - aktualnie zalogowany user*/) {
        userTableDao.deleteById(body.getId());
        return "User id=" + body.getId() + " was successfully deleted";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addUser")
    public ResponseEntity registerUser(@RequestBody UserBody body) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(userRepository.registerUser(body)));
    }
}
