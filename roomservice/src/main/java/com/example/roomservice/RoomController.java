package com.example.roomservice;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RoomController {

    private final RoomRepository repository;

    RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rooms")
    List<Room> findAll() {
        return repository.findAll();
    }

    @GetMapping("/rooms/{id}")
    Room findOne(@PathVariable Long id) {
        Optional<Room> room = repository.findById(id);
        if (room.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No room found with the given ID");
        }
        return room.get();
    }

    @PostMapping("/rooms")
    Room newRoom(@RequestBody Room room) {
        return repository.save(room);
    }

    @PutMapping("/rooms/{id}")
    Room updateRoom(@RequestBody Room newRoom, @PathVariable Long id) {
        return repository.findById(id).map(room -> {
            room.setName(newRoom.getName());
            room.setSize(newRoom.getSize());
            room.setCapacity(newRoom.getCapacity());
            
            room.setAmenities(newRoom.getAmenities());
            return repository.save(room);
        }).orElseGet(() -> repository.save(newRoom));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/rooms/{id}")
    void deleteRoom(@PathVariable Long id) {
        repository.deleteById(id);
    }
}