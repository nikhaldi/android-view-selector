package com.nikhaldimann.viewselector;

public class InvalidSelectorException extends RuntimeException {

    public InvalidSelectorException(String message) {
        super(message);
    }

    public InvalidSelectorException(String message, Exception cause) {
        super(message, cause);
    }
}
