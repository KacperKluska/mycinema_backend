package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.configuration.Role;
import pl.studia.Kacper.myCinema.entities.RoleEntity;

import java.util.List;

public interface RoleDao extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findAllById(int roleId);
}
