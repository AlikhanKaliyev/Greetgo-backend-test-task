package kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.exception;

public class NoContactFoundException extends RuntimeException{
    public NoContactFoundException() {
        super("No contact with such id or telephone number");
    }
}
