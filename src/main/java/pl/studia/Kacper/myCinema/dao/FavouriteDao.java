package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.FavouriteEntity;

import java.util.List;
import java.util.Optional;

public interface FavouriteDao extends JpaRepository<FavouriteEntity, Integer> {
    List<FavouriteEntity> findAllByFilmId(int id);

    List<FavouriteEntity> findAllByUserId(int id);

    Optional<FavouriteEntity> findAllByUserIdAndFilmId(int filmId, int userId);
}
