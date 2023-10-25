package kz.greetgo.gyzjutqwqvwlzxcbzcfr.exception;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactExceptionHandler {


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity(new ErrorResponse("Request body is missing: " + e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContactFoundException.class)
    public ResponseEntity handleNoContactFoundException(NoContactFoundException e) {
        return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FilterDataException.class)
    public ResponseEntity handleFilterDataException(FilterDataException e) {
        return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatePhoneNumberException.class)
    public ResponseEntity handleDuplicatePhoneNumberException(DuplicatePhoneNumberException e) {
        return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
