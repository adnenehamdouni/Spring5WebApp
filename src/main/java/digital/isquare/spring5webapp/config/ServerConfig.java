package digital.isquare.spring5webapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "server")
public class ServerConfig {

    private Address address;
    private Map<String, String> resourcesPath;

    // getters and setters

}
