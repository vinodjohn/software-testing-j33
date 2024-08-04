package org.example.utils;

import org.example.exceptions.UserValidationException;
import org.example.models.User;
import org.example.models.UserType;

/**
 * Validation utils for User
 *
 * @author Vinod John
 * @Date 04.08.2024
 */
public class UserValidator {
    public boolean isAdmin(User user) throws UserValidationException {
        String fullName = user.getFirstName() + " " + user.getLastName();

        if (user.getUserType() == null) {
            throw new NullPointerException(String.format("The user type is null for user: %s", fullName));
        }

        if (UserType.ADMIN.equals(user.getUserType())) {
            return true;
        } else {
            throw new UserValidationException(fullName, "User admin check failed!");
        }
    }

    public String encodePassword(String password) {
        int midIndex = password.length() / 2;
        return password.substring(0, midIndex) + "#sda_java#" + password.substring(midIndex);
    }
}
