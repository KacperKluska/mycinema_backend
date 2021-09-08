package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PersonToFilmEntityPK implements Serializable {

    @Column(name = "person_id")
    private int personId;

    @Column(name = "film_id")
    private int filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        PersonToFilmEntityPK that = (PersonToFilmEntityPK) o;
        return Objects.equals(personId, that.personId)
                && Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, filmId);
    }
}
