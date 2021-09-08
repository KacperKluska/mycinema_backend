package pl.studia.Kacper.myCinema.requestBodies;

import lombok.Data;

@Data
public class LoginBody {
    private String login;
    private String password;
}
