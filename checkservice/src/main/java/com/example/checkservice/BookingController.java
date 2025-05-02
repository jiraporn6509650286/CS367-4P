package com.example.checkservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@CrossOrigin
public class BookingController {

    private final BookingRepository repository;

    public BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return repository.save(booking);
    }

    @GetMapping("/history")
    public List<Booking> getHistoryByStudent(@RequestParam String studentId) {
        return repository.findByUserName(studentId);
    }

    @GetMapping("/by-room")
    public List<Booking> getByRoomAndDate(@RequestParam Long roomId, @RequestParam String date) {
        return repository.findByRoomIdAndDate(roomId, LocalDate.parse(date));
    }

    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable Long id) {
        repository.deleteById(id);
    }
}