package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.FavouriteDao;
import pl.studia.Kacper.myCinema.entities.FavouriteEntity;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class FavouriteRepository {
    private final FavouriteDao repository;

    @Transactional
    public String createFavouriteFilmForUser(int filmId, int userId){
        FavouriteEntity favouriteEntity = new FavouriteEntity();
        favouriteEntity.setFilmId(filmId);
        favouriteEntity.setUserId(userId);
        repository.save(favouriteEntity);
        return "Film added to user favourite films tab";
    }

    @Transactional
    public boolean deleteFavouriteFilmForUser(int filmId, int userId){
        List<FavouriteEntity> favouriteEntity = repository.findAllByUserId(userId);
        if (favouriteEntity.size() == 0){
            return false;
        }
        favouriteEntity.forEach(watchLaterEntity -> {
            if (watchLaterEntity.getFilmId() == filmId){
                repository.delete(watchLaterEntity);
            }
        });

        return true;
    }

    @Transactional
    public List<FavouriteEntity> getFavouriteFilmsByUserId(int userId){
        List<FavouriteEntity> favouriteEntities = repository.findAllByUserId(userId);
        if (favouriteEntities.size() == 0){
            return null;
        }
        return favouriteEntities;
    }
}
