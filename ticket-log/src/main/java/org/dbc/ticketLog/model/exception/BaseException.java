package org.dbc.ticketLog.model.exception;

public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }
}
