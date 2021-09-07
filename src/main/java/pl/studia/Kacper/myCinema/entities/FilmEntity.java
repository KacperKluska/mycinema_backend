package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "film")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "length")
    private Time length;

    @Basic
    @Column(name = "pegi")
    private int pegi;

    @Basic
    @Column(name = "release")
    private Date release;

    @Basic
    @Column(name = "user_rate")
    private Double userRate;

    @Basic
    @Column(name = "img")
    private String img;

    @Basic
    @Column(name = "trailer")
    private String trailer;

    @Basic
    @Column(name = "type")
    private int type;

    @Basic
    @Column(name = "description")
    private String description;
}
