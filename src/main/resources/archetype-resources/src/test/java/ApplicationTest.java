#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.dto.HelloDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApplicationTest {

    private static final String HELLO_ENDPOINT = "api/hello";

    @Value(value = "${symbol_dollar}{local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldRespondWithHelloMessage() {
        HelloDTO helloDTO = restTemplate.getForObject(getHelloEndpointUrl(), HelloDTO.class);

        assertThat(helloDTO.getMessage()).isEqualTo("Hello World!");
    }

    private String getHelloEndpointUrl() {
        return getLocalServerUrl() + HELLO_ENDPOINT;
    }

    private String getLocalServerUrl() {
        return String.format("http://localhost:%d/", port);
    }
}
