package digital.isquare.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Enabling JPA Auditing
public class Spring5WebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring5WebAppApplication.class, args);
    }

}
