package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.RoleDao;
import pl.studia.Kacper.myCinema.dao.UserRoleDao;
import pl.studia.Kacper.myCinema.dao.UserTableDao;
import pl.studia.Kacper.myCinema.entities.RoleEntity;
import pl.studia.Kacper.myCinema.entities.UserRoleEntity;
import pl.studia.Kacper.myCinema.entities.UserTableEntity;
import pl.studia.Kacper.myCinema.requestBodies.UserBody;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserTableRepository {
    private final UserTableDao repository;
    private final UserRoleDao roleDao;
    private final int USER = 1;
    private final int ADMIN = 2;

    @Transactional
    public int getUserByLoginAndPassword(String login, String password) {
        //password na md5
        Optional<UserTableEntity> userTableEntity = repository.findByLoginAndPassword(login, password);
        return userTableEntity.map(UserTableEntity::getId).orElse(0);
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

        UserTableEntity userTableEntity = new UserTableEntity();
        userTableEntity.setLogin(user.getLogin());
        userTableEntity.setEmail(user.getEmail());
        userTableEntity.setRole(new HashSet<>(Arrays.asList(roleDao.findByRole("ROLE_USER"))));
        String codedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        userTableEntity.setPassword(codedPassword);
        repository.save(userTableEntity);
        return "Account created. You can log in now.";
    }

}
