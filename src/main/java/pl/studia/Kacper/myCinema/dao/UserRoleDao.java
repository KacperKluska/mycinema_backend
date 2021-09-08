package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.UserRoleEntity;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRoleEntity, Integer> {

    UserRoleEntity findAllById(int roleId);

    UserRoleEntity findByRole(String roleName);

    @Override
    List<UserRoleEntity> findAll();
}
