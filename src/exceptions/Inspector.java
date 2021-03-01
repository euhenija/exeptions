package exceptions;

public class Inspector {

    public int checkTheMark(int mark) throws MarkIsOutOfBoundException {
        if (mark > 10 || mark <= 0) {
            MarkIsOutOfBoundException markProblem = new MarkIsOutOfBoundException();
            throw markProblem;
        }
        return mark;
    }

}

