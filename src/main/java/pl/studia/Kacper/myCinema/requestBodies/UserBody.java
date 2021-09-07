package pl.studia.Kacper.myCinema.requestBodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBody {
    String login;
    String email;
    String password;
}
