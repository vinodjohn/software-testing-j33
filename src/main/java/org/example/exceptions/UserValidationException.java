package org.example.exceptions;

/**
 * Exception to handle user validation
 *
 * @author Vinod John
 * @Date 04.08.2024
 */
public class UserValidationException extends Exception {
    public UserValidationException(String name, String message) {
        super(String.format("User validation failed for user: %s, Error: %s", name, message));
    }
}
