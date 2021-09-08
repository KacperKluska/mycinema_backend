package pl.studia.Kacper.myCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("pl.studia.Kacper.myCinema")
@EnableJpaRepositories("pl.studia.Kacper.myCinema")
public class MyCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCinemaApplication.class, args);
    }

}
