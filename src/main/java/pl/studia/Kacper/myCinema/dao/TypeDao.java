package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.TypeEntity;

public interface TypeDao extends JpaRepository<TypeEntity, Integer> {
}
