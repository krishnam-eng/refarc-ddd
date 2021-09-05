package com.clap.lms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class LMSApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(LMSApplication.class, args);
  }

  @Override
  public void run(String... args) {
    // Do nothing now. I will update this with data pre population logic.
  }
}
