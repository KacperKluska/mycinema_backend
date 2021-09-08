package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.configuration.Role;
import pl.studia.Kacper.myCinema.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAllByRole_Role(Role role);

    Optional<UserEntity> findByLogin(String login);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByPassword(String password);

    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
