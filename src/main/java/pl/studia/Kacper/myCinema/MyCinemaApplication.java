package pl.studia.Kacper.myCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.studia.Kacper.myCinema.dao.UserTableDao;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserTableDao.class)
public class MyCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCinemaApplication.class, args);
	}

}
