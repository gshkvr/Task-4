package by.epam.kvirikashvili.task4.exception;

public class IncorrectInputFileException extends Exception {
    static final long serialVersionUID = 4383333877147921099L;

    public IncorrectInputFileException() {
        super();
    }

    public IncorrectInputFileException(String message) {
        super(message);
    }

    public IncorrectInputFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputFileException(Throwable cause) {
        super(cause);
    }

    protected IncorrectInputFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
