package by.training.finance_counter.service.exception;

import java.io.IOException;

public class ServiceException extends IOException {
    public ServiceException() {
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
