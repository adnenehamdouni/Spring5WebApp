package digital.isquare.spring5webapp;

import digital.isquare.spring5webapp.config.IsquareConfig;
import digital.isquare.spring5webapp.config.ServerConfig;
;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(loader= AnnotationConfigContextLoader.class,
        classes = {//ServerConfigFactory.class,
                IsquareConfig.class})
@ActiveProfiles("dev")
public class BindingPropertiesToUserDefinedPOJOUnitTest {

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private IsquareConfig isquareConfig;


    @Test
    void givenUserConf_whenBindingPropertiesFile_thenAllFieldsAreSet() {

    }
    @Test
    void givenUserDefinedPOJO_whenBindingPropertiesFile_thenAllFieldsAreSet() {
        assertEquals("192.168.0.1", serverConfig.getAddress().getIp());

        Map<String, String> expectedResourcesPath = new HashMap<>();
        expectedResourcesPath.put("imgs", "/root/dev/imgs");
        assertEquals(expectedResourcesPath, serverConfig.getResourcesPath());
    }
}
