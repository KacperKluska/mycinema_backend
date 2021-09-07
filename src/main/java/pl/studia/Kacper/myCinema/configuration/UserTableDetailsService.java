package pl.studia.Kacper.myCinema.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.studia.Kacper.myCinema.dao.UserDao;
import pl.studia.Kacper.myCinema.entities.UserEntity;

import java.util.Optional;

@Service
public class UserTableDetailsService implements UserDetailsService {

    UserDao repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserEntity> user = repository.findByLogin(login);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + login));
        return user.map(MyUserDetails::new).get();
    }
}
