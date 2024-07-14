package ch.zli.m223.repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;


public interface BookingRepository extends JpaRepository<BookingImpl, Long>{
    Optional<List<BookingImpl>> findByUserId(Long userId);
    Optional<BookingImpl> findByBookingDate(Time startTime);

}