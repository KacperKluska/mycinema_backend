package pl.studia.Kacper.myCinema.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.studia.Kacper.myCinema.dao.UserDao;
import pl.studia.Kacper.myCinema.entities.UserEntity;
import pl.studia.Kacper.myCinema.repositories.UserRepository;
import pl.studia.Kacper.myCinema.requestBodies.IdBody;
import pl.studia.Kacper.myCinema.requestBodies.UserBody;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserDao userDao;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUsers")
    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/users")
    public void deleteUser(@RequestBody IdBody body/*@AuthenticationPrincipal MyUserDetails user - aktualnie zalogowany user*/) {
        userDao.deleteById(body.getId());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/addUser")
    public void registerUser(@RequestBody UserBody body) {
        userRepository.registerUser(body);
    }
}
