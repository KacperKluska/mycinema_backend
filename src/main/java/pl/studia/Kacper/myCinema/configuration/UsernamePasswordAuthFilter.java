package pl.studia.Kacper.myCinema.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.studia.Kacper.myCinema.requestBodies.LoginBody;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsernamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authManager;

    public UsernamePasswordAuthFilter(AuthenticationManager authManager) {
        super();
        this.authManager = authManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            // Get username & password from request (JSON) any way you like
            LoginBody authRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginBody.class);

            Authentication auth = new UsernamePasswordAuthenticationToken(authRequest.getLogin(),
                    authRequest.getPassword());

            return authManager.authenticate(auth);
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        if (logger.isDebugEnabled()) {
            logger.debug("Authentication success. Updating SecurityContextHolder to contain: "
                    + authResult);
        }

        // custom code

        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }
}
