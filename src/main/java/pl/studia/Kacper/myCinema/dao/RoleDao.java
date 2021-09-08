package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.RoleEntity;

public interface RoleDao extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findAllById(int roleId);
}
