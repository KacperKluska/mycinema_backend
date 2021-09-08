package pl.studia.Kacper.myCinema.requestBodies;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class FilmBody {
    int typeId;
    String title;
    Time length;
    int PEGI;
    Date releaseDate;
    double userRate;
    String imgLink;
    String trailerLink;
    String description;
}
