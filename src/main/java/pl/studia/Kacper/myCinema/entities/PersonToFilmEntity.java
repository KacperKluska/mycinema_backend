package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "person_to_film")
public class PersonToFilmEntity {

    @EmbeddedId
    PersonToFilmEntityPK id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    PersonEntity person;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    FilmEntity film;
}
