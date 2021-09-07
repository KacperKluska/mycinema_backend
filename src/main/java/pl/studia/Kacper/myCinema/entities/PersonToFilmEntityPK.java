package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class PersonToFilmEntityPK implements Serializable {

    @Column(name = "person_id")
    private int personId;

    @Column(name = "film_id")
    private int filmId;
}
