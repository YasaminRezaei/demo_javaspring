package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.APRIL;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return  args -> {
               Student mariam = new Student(
                            "mariam",
                            "mariam@gmail.com",
                            LocalDate.of(2000, APRIL,18)

                    );
            Student mehdi = new Student(
                    "mehdi",
                    "mehdi@gmail.com",
                    LocalDate.of(2004, APRIL,18)
            );

            repository.saveAll(
                    List.of(mariam,mehdi)
            );
        };
    }
}
