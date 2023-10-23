package kz.greetgo.gyzjutqwqvwlzxcbzcfr.exception;

public class NoContactFoundException extends RuntimeException{
    public NoContactFoundException() {
        super("No contact with such id or telephone number");
    }
}
