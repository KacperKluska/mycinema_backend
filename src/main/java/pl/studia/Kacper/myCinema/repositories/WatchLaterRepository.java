package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.WatchLaterDao;
import pl.studia.Kacper.myCinema.entities.WatchLaterEntity;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class WatchLaterRepository {
    private final WatchLaterDao repozytorium;

    //TODO jeden film mozna dodać 2 razy a to jest błąd
    @Transactional
    public String createWatchLaterFilmForUser(int filmId, int userId){
        WatchLaterEntity watchLaterEntity = new WatchLaterEntity();
        watchLaterEntity.setFilmId(filmId);
        watchLaterEntity.setUserId(userId);
        repozytorium.save(watchLaterEntity);
        return "Film added to user watch later films tab";
    }

    @Transactional
    public boolean deleteWatchLaterFilmForUser(int filmId, int userId){
        List<WatchLaterEntity> watchLaterList = repozytorium.findAllByUserId(userId);
        if (watchLaterList.size() == 0){
            return false;
        }
        watchLaterList.forEach(watchLaterEntity -> {
           if (watchLaterEntity.getFilmId() == filmId){
               repozytorium.delete(watchLaterEntity);
           }
        });

        return true;
    }

    @Transactional
    public List<WatchLaterEntity> getWatchLaterFilmsByUserId(int userId){
        List<WatchLaterEntity> watchLaterEntities = repozytorium.findAllByUserId(userId);
        if (watchLaterEntities.size() == 0){
            return null;
        }
        return watchLaterEntities;
    }
}
