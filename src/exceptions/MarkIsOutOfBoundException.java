package exceptions;

import university.Student;

public class MarkIsOutOfBoundException extends Exception {

    public MarkIsOutOfBoundException(String message) {
        super(message);
    }


}
