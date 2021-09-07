package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.CommentEntity;

import java.util.List;

public interface CommentDao extends JpaRepository<CommentEntity, Integer> {

    List<CommentEntity> findAllByRate(double rate);
    List<CommentEntity> findByFilmIdAndUserId(int filmId, int userId);
    List<CommentEntity> findAllByFilmId(int id);
}
