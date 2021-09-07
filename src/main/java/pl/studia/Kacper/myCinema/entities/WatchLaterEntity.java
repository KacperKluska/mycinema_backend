package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "watch_later")
public class WatchLaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "user_id")
    private int userId;

    @Basic
    @Column(name = "film_id")
    private int filmId;
}
