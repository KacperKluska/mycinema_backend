package pl.studia.Kacper.myCinema.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.studia.Kacper.myCinema.dao.FilmDao;
import pl.studia.Kacper.myCinema.entities.FilmEntity;
import pl.studia.Kacper.myCinema.requestBodies.FilmBody;
import pl.studia.Kacper.myCinema.requestBodies.MovieAnswerBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class FilmRepository {
    private final FilmDao repository;
    private final TypeRepository typeRepository;

    @Transactional
    public FilmEntity getFilm(int id) {

        Optional<FilmEntity> filmEntity = repository.findById(id);
        return filmEntity.orElse(null);
    }

    //TODO query is case sensitive
    @Transactional
    public MovieAnswerBody getAllFilms(int page, String query) {
        int totalMovies = repository.findByTitleContainingIgnoreCase(query).size();
        List<FilmEntity> paginated;
        Pageable pageItems;
        if (query.equals("")) {
            pageItems = PageRequest.of(page, 4);
        } else {
            pageItems = PageRequest.of(0, 4);
        }
        paginated = repository.findByTitleContainingIgnoreCase(query, pageItems);

        return new MovieAnswerBody(page, totalMovies, paginated);
    }

    @Transactional
    public List<FilmEntity> getFilmByTitle(String title) {
        List<FilmEntity> filmEntities = repository.findByTitle(title);
        if (filmEntities.size() == 0) {
            return null;
        }
        return filmEntities;
    }

    @Transactional
    public String createFilm(FilmBody newFilm) {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setType(typeRepository.getById(newFilm.getTypeId()));
        filmEntity.setTitle(newFilm.getTitle());
        filmEntity.setLength(newFilm.getLength());
        filmEntity.setPegi(newFilm.getPEGI());
        filmEntity.setRelease(newFilm.getReleaseDate());
        filmEntity.setUserRate(newFilm.getUserRate());
        filmEntity.setImg(newFilm.getImgLink());
        filmEntity.setTrailer(newFilm.getTrailerLink());
        filmEntity.setDescription(newFilm.getDescription());
        repository.save(filmEntity);
        return "Successfully added new film to database";
    }

    //TODO do poprawy
    @Transactional
    public boolean deleteFilm(int id) {
        Optional<FilmEntity> filmEntity = repository.findById(id);
        if (!filmEntity.isPresent()) {
            return false;
        }
        repository.delete(filmEntity.get());
        return true;
    }
}
