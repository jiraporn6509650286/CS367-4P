package com.example.checkservice;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserName(String userName); // สำหรับ studentId
    List<Booking> findByRoomIdAndDate(Long roomId, java.time.LocalDate date);
}