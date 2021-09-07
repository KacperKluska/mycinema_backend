package pl.studia.Kacper.myCinema.requestBodies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.studia.Kacper.myCinema.entities.FilmEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MovieAnswerBody {
    int page;
    int totalMovies;
    List<FilmEntity> filmEntities;
}
