package com.formation.app.demo;

import com.formation.app.demo.entity.Console;
import com.formation.app.demo.entity.VideoGame;
import com.formation.app.demo.repository.VideoGameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(VideoGameRepository repository) {
        return args -> {
            Console console = new Console("Xbox 360");
            repository.save(new VideoGame("PUBG", 30f, "Battle Royal", 4, console, "Zelda.jpg"));
        };
    }

}
