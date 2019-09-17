package com.epam.brest.summer.courses2019.web_app;

/**
 * ServerDataAccessException class.
 */
public class ServerDataAccessException extends RuntimeException {

    /**
     * Constructor for ServerDataAccessException.
     * @param message - for output.
     */
    public ServerDataAccessException(final String message) {
        super(message);
    }
}
