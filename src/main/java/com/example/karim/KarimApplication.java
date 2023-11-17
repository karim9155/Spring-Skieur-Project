package com.example.karim;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling /// pour Scheduler
public class KarimApplication  {

    public static void main(String[] args) {
        SpringApplication.run(KarimApplication.class, args);
    }


}
