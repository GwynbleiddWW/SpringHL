package ru.netology.springhl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ru.netology"})
public class SpringHlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHlApplication.class, args);
    }
}

