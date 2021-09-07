package pl.studia.Kacper.myCinema.requestBodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentBody {
    int userId;
    int filmId;
    double userRate;
    String text;
}
