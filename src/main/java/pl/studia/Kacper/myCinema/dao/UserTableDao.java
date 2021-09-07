package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.UserTableEntity;

import java.util.List;
import java.util.Optional;

public interface UserTableDao extends JpaRepository<UserTableEntity, Integer> {
    List<UserTableEntity> findAllByRole(int roleId);
    Optional<UserTableEntity> findByLogin(String login);
    Optional<UserTableEntity> findByEmail(String email);
    Optional<UserTableEntity> findByPassword(String password);
    Optional<UserTableEntity> findByLoginAndPassword(String login, String password);
}
