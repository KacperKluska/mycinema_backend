package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.PersonDao;
import pl.studia.Kacper.myCinema.entities.PersonEntity;

@RequiredArgsConstructor
@Repository
public class PersonRepository {
    private final PersonDao repository;

    @Transactional
    public PersonEntity getPerson(int id) {
        return repository.findById(id).orElse(null);
    }
}
