package com.nikhaldimann.viewselector;

/**
 * Thrown when a selector string can't be parsed.
 */
public class InvalidSelectorException extends RuntimeException {

    public InvalidSelectorException(String message) {
        super(message);
    }

    public InvalidSelectorException(String message, Exception cause) {
        super(message, cause);
    }
}
