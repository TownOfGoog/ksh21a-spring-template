package ch.zli.m223.controller.ticketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.ticketing.dto.BookingDto;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.repository.BookingRepository;
import ch.zli.m223.service.booking.BookingService;
import ch.zli.m223.service.user.UserService;

@RestController
@RequestMapping("/api/v1/member/bookings")
public class BookingMemberController {



    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    BookingDto getBooking(@PathVariable("id") Long id) {
            return new BookingDto(bookingService.getBooking(id));
    }

    @GetMapping("")
    List<Booking> getBookingByUserId(@PathVariable("userId") Long userId){
        return bookingService.getBookingByUserId(userId);
    }

    @PostMapping("")
    public BookingImpl createBooking(@RequestBody BookingDto bookingDto){
        AppUser user = userService.getUser(bookingDto.userId);
        return (BookingImpl) bookingService.addBooking(bookingDto.accepted, bookingDto.startTime, bookingDto.endTime, (Long) user.getId(), bookingDto.reservationOpen);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id){
        bookingService.deleteBooking(id);
    }










}
