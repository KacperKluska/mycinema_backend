package pl.studia.Kacper.myCinema.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.studia.Kacper.myCinema.entities.UserEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

    private int id;
    private String username;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails(UserEntity user) {
        this.id = user.getId();
        this.username = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
        authorities = user.getRole()
                .stream()
                .map(e -> new SimpleGrantedAuthority(e.getRole().name()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
