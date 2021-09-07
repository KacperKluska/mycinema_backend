package pl.studia.Kacper.myCinema.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.studia.Kacper.myCinema.dao.UserTableDao;
import pl.studia.Kacper.myCinema.entities.UserTableEntity;

import java.util.Optional;

@Service
public class UserTableDetailsService implements UserDetailsService {

    UserTableDao repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserTableEntity> user = repository.findByLogin(login);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + login));
        return user.map(MyUserDetails::new).get();
    }
}
