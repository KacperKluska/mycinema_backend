package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "age")
    private int age;

    @Basic
    @Column(name = "height")
    private int height;

    @Basic
    @Column(name = "born")
    private Date born;

    @Basic
    @Column(name = "death")
    private Date death;

    @Basic
    @Column(name = "img")
    private String img;

    @Basic
    @Column(name = "role_id")
    private int roleId;
}
