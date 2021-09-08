package pl.studia.Kacper.myCinema.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.studia.Kacper.myCinema.requestBodies.LoginBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CommonsLog
public class UsernamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {

    public UsernamePasswordAuthFilter(AuthenticationManager authenticationManager) {
        setFilterProcessesUrl("/login");
        setAuthenticationManager(authenticationManager);
        setAuthenticationSuccessHandler(((request, response, auth) -> {
            log.info("Login success");
            response.setStatus(HttpServletResponse.SC_OK);
        }));
        setAuthenticationFailureHandler((request, response, exception) -> {
            log.info(String.format("Login failure: %s", exception.getMessage()));
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        if (!HttpMethod.POST.name().equals(request.getMethod())) {
            throw new AuthenticationServiceException(
                    String.format("Authentication method not supported: %s", request.getMethod())
            );
        }
        UsernamePasswordAuthenticationToken authRequest;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LoginBody credentials = objectMapper.readValue(request.getReader(), LoginBody.class);
            authRequest = new UsernamePasswordAuthenticationToken(
                    credentials.getLogin().trim(),
                    credentials.getPassword()
            );
        } catch (NullPointerException | IOException ex) {
            authRequest = new UsernamePasswordAuthenticationToken("", "");
        }
        setDetails(request, authRequest);
        return getAuthenticationManager().authenticate(authRequest);
    }
}
