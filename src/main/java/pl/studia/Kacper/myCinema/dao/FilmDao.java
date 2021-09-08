package pl.studia.Kacper.myCinema.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.studia.Kacper.myCinema.entities.FilmEntity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface FilmDao extends JpaRepository<FilmEntity, Integer> {
    List<FilmEntity> findByType(int typeId);

    List<FilmEntity> findByPegiGreaterThanEqual(int age);

    List<FilmEntity> findByPegiLessThanEqual(int age);

    List<FilmEntity> findByUserRate(double userRate);

    List<FilmEntity> findByUserRateGreaterThanEqual(double userRate);

    List<FilmEntity> findByUserRateLessThanEqual(double userRate);

    List<FilmEntity> findByLengthGreaterThanEqual(Time time);

    List<FilmEntity> findByLengthLessThanEqual(Time time);

    List<FilmEntity> findByReleaseAfter(Date date);

    List<FilmEntity> findByReleaseBefore(Date date);

    List<FilmEntity> findByTitle(String title);

    List<FilmEntity> findByTitleContainingIgnoreCase(String title, Pageable page);

    //    @Query("select u from FilmEntity u where lower(u.title) like lower(concat('%', :title,'%'))")
    List<FilmEntity> findByTitleContainingIgnoreCase(String title);
}
