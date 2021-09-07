package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comment", schema = "public", catalog = "FilmsForYou")
public class CommentEntity {

    @Id
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment")
    @SequenceGenerator(name = "comment", sequenceName = "commentSequence", allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "rate", length = 20)
    private double rate;

    @Basic
    @Column(name = "text", length = 255)
    private String text;

    @Basic
    @Column(name = "user_id")
    private int userId;

    @Basic
    @Column(name = "film_id")
    private int filmId;
}
