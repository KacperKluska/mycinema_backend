package pl.studia.Kacper.myCinema.repositories;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.UserRoleDao;
import pl.studia.Kacper.myCinema.entities.UserRoleEntity;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRoleRepository {
    private final UserRoleDao repository;

    @Transactional
    public List<UserRoleEntity> getAllRoles(){
        return repository.findAll();
    }

    @Transactional
    public UserRoleEntity getRoleById(int id){
        return repository.findAllById(id);
    }
}
