package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.UserDao;
import pl.studia.Kacper.myCinema.dao.UserRoleDao;
import pl.studia.Kacper.myCinema.entities.UserEntity;
import pl.studia.Kacper.myCinema.requestBodies.UserBody;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final UserDao repository;
    private final UserRoleDao roleDao;
    private final int USER = 1;
    private final int ADMIN = 2;

    @Transactional
    public int getUserByLoginAndPassword(String login, String password) {
        //password na md5
        Optional<UserEntity> userTableEntity = repository.findByLoginAndPassword(login, password);
        return userTableEntity.map(UserEntity::getId).orElse(0);
    }

    @Transactional
    public String registerUser(UserBody user) {
        //TODO dodać walidacje
        if (repository.findByLogin(user.getLogin()).isPresent()){
            return "User with this login already exists.";
        }
        else if (repository.findByEmail(user.getEmail()).isPresent()){
            return "User with this email already exists.";
        }
        else if (repository.findByPassword(user.getPassword()).isPresent()){
            return "Password already in use.";
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(user.getLogin());
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(new HashSet<>(Arrays.asList(roleDao.findByRole("ROLE_USER"))));
        String codedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        userEntity.setPassword(codedPassword);
        repository.save(userEntity);
        return "Account created. You can log in now.";
    }

}
