package ch.zli.m223.service.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Email in use")
public class UserAllredyExistsException extends RuntimeException {
}
