package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.TypeDao;
import pl.studia.Kacper.myCinema.entities.TypeEntity;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TypeRepository {
    private final TypeDao repository;

    @Transactional
    public String getType(int id){
        return repository.findById(id).get().getType();
    }

    @Transactional
    public List<TypeEntity> getAllTypes(){
        List<TypeEntity> typeEntities = repository.findAll();
        if (typeEntities.size() == 0){
            return null;
        }
        return typeEntities;
    }

    @Transactional
    public TypeEntity getById(Integer id) {
        return repository.getOne(id);
    }
}
