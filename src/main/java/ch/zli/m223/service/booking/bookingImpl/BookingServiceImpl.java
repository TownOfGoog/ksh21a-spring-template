package ch.zli.m223.service.booking.bookingImpl;


import java.util.List;
import java.util.Optional;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.service.booking.BookingService;
import ch.zli.m223.service.booking.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import ch.zli.m223.repository.BookingRepository;


import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;


    public BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }


    @Override
    public List<Booking> getBookingsList() {
        return new ArrayList<Booking>(bookingRepository.findAll());
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException());
    }

    @Override
    public Booking getBookingByStartTime(Time startTime) {
        return bookingRepository.findByBookingDate(startTime).orElseThrow(()-> new ObjectNotFoundException());
    }

    @Override
    public List<Booking> getBookingByUserId(Long userId) {
        return new ArrayList<Booking>(bookingRepository.findByUserId(userId).orElseThrow(() -> new ObjectNotFoundException()));
    }

    @Override
    public Booking addBooking(Boolean accepted, Time startTime, Time endTime, Long userId, Boolean reservationOpen) {
        BookingImpl booking = new BookingImpl();
        booking.setAccepted(accepted);
        booking.setUserId(userId);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setReservationOpen(reservationOpen);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking updateBooking(Long id, Boolean accepted) {
        BookingImpl booking = bookingRepository.findById(id).orElseThrow(()-> new RuntimeException("Booking not found"));
        booking.setBookingAcceptance(accepted);
        return bookingRepository.save(booking);
    }




}
