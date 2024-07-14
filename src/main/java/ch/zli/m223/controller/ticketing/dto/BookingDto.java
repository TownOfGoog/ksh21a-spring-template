package ch.zli.m223.controller.ticketing.dto;

import java.sql.Time;

import ch.zli.m223.model.Booking;

public class BookingDto {
    public Long id;
    public Long userId;
    public Boolean accepted;
    public Time startTime;
    public Time endTime;
    public Boolean reservationOpen;


    public BookingDto(Booking booking) {
        id = booking.getId();
        accepted = booking.getAccepted();
        startTime = booking.getStartTime();
        endTime = booking.getEndTime();
        reservationOpen = booking.getReservationOpen();
    }


    public Boolean getAccepted() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccepted'");
    }




}
