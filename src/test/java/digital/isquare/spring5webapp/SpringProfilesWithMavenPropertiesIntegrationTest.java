package digital.isquare.spring5webapp;

import digital.isquare.spring5webapp.component.DatasourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootTest
public class SpringProfilesWithMavenPropertiesIntegrationTest {

    @Autowired
    DatasourceConfig datasourceConfig;

    @Autowired
    private Environment env;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Test
    public void setupDatasource() {
        datasourceConfig.setup();
    }

    @Test
    public void dataFromPropertiesByEnvironment() {
        //
        log.info("jdbc.driverClassName: {}",env.getProperty("spring.datasource.url"));
        //
        log.info("jdbc.driverClassName: {}",env.getProperty("jdbc.driverClassName"));
        log.info("jdbc.url: {}",env.getProperty("jdbc.url"));
        log.info("jdbc.user: {}",env.getProperty("jdbc.user"));
        log.info("jdbc.pass: {}",env.getProperty("jdbc.pass"));
    }

    @Test
    public void dataFromPropertiesByProfiles() {
        //
        log.info("jdbc.driverClassName: {}",datasourceUrl);
        //
        log.info("jdbc.driverClassName: {}",env.getProperty("jdbc.url"));
        log.info("jdbc.driverClassName: {}",env.getProperty("jdbc.user"));
        log.info("jdbc.driverClassName: {}",env.getProperty("jdbc.pass"));
    }
}
