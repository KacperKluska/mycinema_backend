package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.CommentDao;
import pl.studia.Kacper.myCinema.entities.CommentEntity;
import pl.studia.Kacper.myCinema.entities.WatchLaterEntity;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CommentRepository {
    private final CommentDao repository;

    @Transactional
    public String createComment(String text, double rate, int filmId, int userId){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setFilmId(filmId);
        commentEntity.setUserId(userId);
        commentEntity.setText(text);
        commentEntity.setRate(rate);
        repository.save(commentEntity);
        return "Successfully added new comment";
    }

    //jednak działa
    @Transactional
    public boolean deleteComment(int id){
        Optional<CommentEntity> commentEntity = repository.findById(id);
        if (!commentEntity.isPresent()){
            return false;
        }
        repository.delete(commentEntity.get());
        return true;
    }

    //w razie jak by to wyżej nie działało lub zmieniła by się mi koncepcja
//    @Transactional
//    public boolean deleteUserCommentFromFilm(int filmId, int userId){
//        List<CommentEntity> commentEntities = repository.findAllByFilmId(filmId);
//        if (commentEntities.size() == 0){
//            return false;
//        }
//        commentEntities.forEach(entity -> {
//            if (entity.getUserId() == userId){
//                repository.delete(entity);
//            }
//        });
//
//        return true;
//    }

    @Transactional
    public List<CommentEntity> getFilmComments(int filmId){
        List<CommentEntity> commentEntities = repository.findAllByFilmId(filmId);
        if (commentEntities.size() == 0){
            return null;
        }
        return commentEntities;
    }

    @Transactional
    public List<CommentEntity> getAllComments(){
        List<CommentEntity> commentEntities = repository.findAll();
        if (commentEntities.size() == 0){
            return null;
        }
        return commentEntities;
    }


}
