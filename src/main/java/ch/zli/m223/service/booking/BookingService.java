package ch.zli.m223.service.booking;

import java.sql.Time;
import java.util.List;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.user.exception.InvalidIdException;

public interface BookingService {
    
    /**
     * @return a possibly empty list of bookings
     */
    List<Booking> getBookingsList();

    /**
     * Get a single user by id
     * @param id the booking id (required)
     * @return the booking
     * @throws InvalidIdException, ObjectNotFoundException
     */
    Booking getBooking(Long id);


    /**
     * Get a single user by id
     * @param startTime the startTime of the booking (required)
     * @return the booking
     * @throws InvalidIdException, ObjectNotFoundException
     */
    Booking getBookingByStartTime(Time startTime);

    /**
     * Get a single user by id
     * @param id the user id (required)
     * @return the booking
     * @throws InvalidIdException, ObjectNotFoundException
     */
    List<Booking> getBookingByUserId(Long userId);

    /**
     * Add a new user
     * @param accepted standard false, only true after confirmed by an admin
     * @param startTime start of booking
     * @param endTime end of booking (required)
     * @param userId id of the User (required)
     * @param reservationOpen standardised true, only false after booking event concluded
     * @return the newly made booking
     * @throws InvalidDataException, BookingAllredyExistsException
     */
    
    Booking addBooking(Boolean accepted, Time startTime, Time endTime, Long userId, Boolean reservationOpen);
    /**
     * Delete a user
     * @param id the booking id (required)
     * @throws InvalidIdException
     */
    void deleteBooking(Long id);

    /**
     * Update a booking
     * 
     * @param id the booking id (required)
     * @return the changed user
     * @throws InvalidIdException, ObjectNotFoundException, ObjectAllredyExistsException
     */
    Booking updateBooking(Long id, Boolean accepted);



}
