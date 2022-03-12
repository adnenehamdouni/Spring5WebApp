package digital.isquare.spring5webapp.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("prod")
public class ProductionDatasourceConfig implements DatasourceConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Override
    public void setup() {

        log.info("Setting up datasource for PRODUCTION environment. ");
        log.info("Datasource URL =  {}", datasourceUrl);
    }
}
