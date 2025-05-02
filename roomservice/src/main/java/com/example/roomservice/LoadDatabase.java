package com.example.roomservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RoomRepository repository) {
        return args -> {
            log.info("loading " + repository.save(
                new Room("Study Room A", "4x4", 6, List.of("wifi", "whiteboard"))));
            log.info("loading " + repository.save(
                new Room("Meeting Room B", "5x5", 10, List.of("projector", "AC"))));
        };
    }
}
