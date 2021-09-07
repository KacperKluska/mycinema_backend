package pl.studia.Kacper.myCinema.entities;

import lombok.Getter;
import lombok.Setter;
import pl.studia.Kacper.myCinema.configuration.Role;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_role")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
