package ch.zli.m223.service.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid ID")
public class InvalidIdException extends RuntimeException {
}

