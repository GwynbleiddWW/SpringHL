package ru.netology.springhl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringHlApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;
    public static GenericContainer<?> devapp = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8090);
    public static GenericContainer<?> prodapp = new GenericContainer<>("progapp:latest")
            .withExposedPorts(8081);


    @BeforeAll
    public static void setUp() {
        devapp.start();
        prodapp.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devapp.getMappedPort(8080), String.class);
        System.out.println(forEntity.getBody());

        ResponseEntity<String> forEntityTwo = restTemplate.getForEntity("http://localhost:" + prodapp.getMappedPort(8080), String.class);
        System.out.println(forEntityTwo.getBody());
    }
}
