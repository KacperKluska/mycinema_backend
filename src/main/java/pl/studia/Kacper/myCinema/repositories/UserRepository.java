package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.UserDao;
import pl.studia.Kacper.myCinema.dao.UserRoleDao;
import pl.studia.Kacper.myCinema.entities.UserEntity;
import pl.studia.Kacper.myCinema.requestBodies.UserBody;

import java.util.Collections;
import java.util.HashSet;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final UserDao repository;
    private final UserRoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String registerUser(UserBody user) {
        //TODO dodać walidacje
        if (repository.findByLogin(user.getLogin()).isPresent()) {
            return "User with this login already exists.";
        } else if (repository.findByEmail(user.getEmail()).isPresent()) {
            return "User with this email already exists.";
        } else if (repository.findByPassword(user.getPassword()).isPresent()) {
            return "Password already in use.";
        }

//        chcesz np zrobic sobie metode na update hasla usera
//                pobierasz sobie usera z bazy
//                user = usersRepository.getById(id)
//                     hashedPassword = user.getPassword   -> haslo jesyt zahaszowane
//        if (passwordEncoder.matches(noweHasloNiezaszyfrowaneJeszcze, hashedPassword)) { // 1 parametr niezaszyfrowane nowe, drugi zaszyfrowane z bazy przyjmuje
//            throw new PasswordUnchangedException(); -> haslo musi bhyc inne
//        }

        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(user.getLogin());
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(new HashSet<>(Collections.singletonList(roleDao.findByRole("ROLE_USER"))));
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(userEntity);
        return "Account created. You can log in now.";
    }
}
