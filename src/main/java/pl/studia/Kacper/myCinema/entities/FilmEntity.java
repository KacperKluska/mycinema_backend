package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

    @Column(name = "title")
    private String title;

    @Column(name = "length")
    private Time length;

    @Column(name = "pegi")
    private int pegi;

    @Column(name = "release")
    private Date release;

    @Column(name = "user_rate")
    private Double userRate;

    @Column(name = "img")
    private String img;

    @Column(name = "trailer")
    private String trailer;

    @OneToOne
    @JoinColumn(name = "type_id")
    private TypeEntity type;

    @Column(name = "description")
    private String description;
}
