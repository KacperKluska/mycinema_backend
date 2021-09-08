package pl.studia.Kacper.myCinema.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.studia.Kacper.myCinema.dao.UserDao;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserDao repository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        return repository.findByLogin(login)
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Not found: " + login));
    }
}
