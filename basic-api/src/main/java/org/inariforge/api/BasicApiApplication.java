package org.inariforge.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * BasicArchitecture 主應用程式入口.
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = "org.inariforge")
public class BasicApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApiApplication.class, args);
    }
}
