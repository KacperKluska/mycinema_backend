package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.WatchLaterEntity;

import java.util.List;
import java.util.Optional;

public interface WatchLaterDao extends JpaRepository<WatchLaterEntity, Integer> {
    List<WatchLaterEntity> findAllByFilmId(int id);

    List<WatchLaterEntity> findAllByUserId(int id);

    Optional<WatchLaterEntity> findAllByUserIdAndFilmId(int filmId, int userId);
}
