package com.clap.lms.infrastructure.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.clap.lms")
public class LMSAppConfiguration implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LMSAppConfiguration.class, args);
    }

    @Override
    public void run(String... args) {
        // Do nothing now. I will update this with data pre population logic.
    }
}
