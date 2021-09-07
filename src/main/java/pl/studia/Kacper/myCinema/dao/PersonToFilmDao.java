package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.PersonToFilmEntity;

import java.util.List;

public interface PersonToFilmDao extends JpaRepository<PersonToFilmEntity, Integer> {
    List<PersonToFilmEntity> findByPersonId(int personId);
    List<PersonToFilmEntity> findByFilmId(int filmId);
}
