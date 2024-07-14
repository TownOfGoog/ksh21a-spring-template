package ch.zli.m223.controller.ticketing;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.ticketing.dto.BookingDto;
import ch.zli.m223.controller.user.dto.BookingUpdateDto;

import ch.zli.m223.service.booking.BookingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/bookings")
@RequiredArgsConstructor
public class BookingAdminController {
    private final BookingService bookingService;

    /**
     * Get list of all existing users
     * 
     * @return al list of users & HttpStatus.OK
     */
    @GetMapping()
    List<BookingDto> getBookingsList() {
        return bookingService.getBookingsList().stream()
        .map( booking -> new BookingDto(booking))
        .collect(Collectors.toList());
    }

    /**
     * Get a user by its Id
     * 
     * @param id the users id
     * @return (HttpStatus.OK & the user as UserDto) or HttpStatus.BAD_REQUEST if user not found
     */
    @GetMapping("/{id}")
    BookingDto getBooking(@PathVariable("id") Long id) {
            return new BookingDto(bookingService.getBooking(id));
    }

    /**
     * Update a user given by its Id
     * 
     * @param id the users id
     * @param data everything you want to be changed in the user object
     * @return (HttpStatus.OK & the user as UserDto) or HttpStatus.CONFLICT or HttpStatus.BAD_REQUEST  if user not found
     */
    @PatchMapping("/{id}")
    BookingDto updateBooking(
        @PathVariable("id") Long id,
        @RequestBody BookingUpdateDto data
    ) {
        return new BookingDto(
            bookingService.updateBooking(id, data.accepted)
        );
    }

    /**
     * Delete a user by Id from the server
     * 
     * @param id the users id
     * @return HttpStatus.OK
     */
    @DeleteMapping("/{id}")
    void deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
    }

    /**
     * Change users role by id
     * @param id the users id
     * @return (HttpStatus.OK & the user as UserDto) or HttpStatus.BAD_REQUEST if user not found
     */
    //@PatchMapping("/{id}")
    //Booking setUserRole(@PathVariable Long id, @RequestBody BookingImpl booking) {
    //    return bookingService.updateBooking(id, booking.getAccepted());
    //}
}
