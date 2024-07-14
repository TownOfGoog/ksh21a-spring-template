package ch.zli.m223.service.booking.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Object not found")
public class ObjectNotFoundException extends RuntimeException {
}