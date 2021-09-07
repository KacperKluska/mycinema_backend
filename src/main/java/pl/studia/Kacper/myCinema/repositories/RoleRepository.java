package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.RoleDao;
import pl.studia.Kacper.myCinema.entities.RoleEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RoleRepository {
    private final RoleDao repozytorium;

    @Transactional
    public void createRole(String role){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(role);
        repozytorium.save(roleEntity);
    }

    @Transactional
    public String getRole(int id){
        Optional<RoleEntity> roleEntity = repozytorium.findById(id);
        return roleEntity.map(RoleEntity::getRole).orElse(null);
    }
}
