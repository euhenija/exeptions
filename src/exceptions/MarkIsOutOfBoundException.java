package exceptions;

import university.Student;

public class MarkIsOutOfBoundException extends Exception{

    public MarkIsOutOfBoundException() {
    }

    public MarkIsOutOfBoundException(String message) {
        super(message);
    }

    public MarkIsOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkIsOutOfBoundException(Throwable cause) {
        super(cause);
    }
}
