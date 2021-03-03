package exceptions;

public class Inspector {

    public int checkTheMark(int mark) throws MarkIsOutOfBoundException {
        if (mark > 10 || mark <= 0) {
            throw new MarkIsOutOfBoundException();
        }
        return mark;
    }

}

