package ch.zli.m223.model.impl;

import java.sql.Time;


import ch.zli.m223.model.Booking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="Booking")
public class BookingImpl implements Booking{
    @Id
    @GeneratedValue
    private Long id;
    private Boolean accepted;
    private Time startTime;
    private Time endTime;
    private Long userId;
    private Boolean reservationOpen;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Boolean getAccepted() {
        return accepted;
    }

    @Override
    public Time getStartTime() {
        return startTime;
    }

    @Override
    public Time getEndTime() {
        return endTime;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public Boolean getReservationOpen() {
        return reservationOpen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setReservationOpen(Boolean reservationOpen) {
        this.reservationOpen = reservationOpen;
    }



    public void setBookingAcceptance(Boolean accepted2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBookingAcceptance'");
    }


    
}


