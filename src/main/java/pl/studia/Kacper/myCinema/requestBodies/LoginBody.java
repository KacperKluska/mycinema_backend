package pl.studia.Kacper.myCinema.requestBodies;

import lombok.Data;

@Data
public class LoginBody {
    private final String login;
    private final String password;
}
