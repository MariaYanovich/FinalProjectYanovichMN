package by.training.finance_counter.exception;

import java.io.IOException;

public class DAOException extends IOException {
    public DAOException() {
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
