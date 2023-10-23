package kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.exception;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactExceptionHandler {
    @ExceptionHandler(NoContactFoundException.class)
    public ResponseEntity handleNoContactFoundException(NoContactFoundException e) {
        return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FilterDataException.class)
    public ResponseEntity handleFilterDataException(FilterDataException e) {
        return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
