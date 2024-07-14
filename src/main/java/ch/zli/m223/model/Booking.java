package ch.zli.m223.model;

import java.sql.Time;

public interface Booking {
    Long getId();

    Boolean getAccepted();
    Time getStartTime();
    Time getEndTime();
    Long getUserId();
    Boolean getReservationOpen();

    
}
