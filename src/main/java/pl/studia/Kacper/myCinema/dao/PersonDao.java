package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.PersonEntity;

import java.util.Date;
import java.util.List;

public interface PersonDao extends JpaRepository<PersonEntity, Integer> {
    List<PersonEntity> findByNameAndSurname(String name, String surname);

    List<PersonEntity> findByAge(int age);

    List<PersonEntity> findByHeight(int height);

    List<PersonEntity> findByRoleId(int roleId);

    List<PersonEntity> findByBornAfter(Date date);

    List<PersonEntity> findByBornBefore(Date date);

    List<PersonEntity> findByDeathAfter(Date date);

    List<PersonEntity> findByDeathBefore(Date date);
}
