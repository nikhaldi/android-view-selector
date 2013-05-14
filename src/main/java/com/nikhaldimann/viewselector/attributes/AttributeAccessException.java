package com.nikhaldimann.viewselector.attributes;

/**
 * Exception thrown when accessing a view attribute by name fails.
 */
public class AttributeAccessException extends RuntimeException {

    public AttributeAccessException(Exception cause) {
        super(cause);
    }

    public AttributeAccessException(String message, Exception cause) {
        super(message, cause);
    }

}
