package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public class PersonToFilmEntityPK implements Serializable {

    @Column(name = "person_id")
    @Id
    private int personId;

    @Column(name = "film_id")
    @Id
    private int filmId;
}
