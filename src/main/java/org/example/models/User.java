package org.example.models;

import lombok.Data;

/**
 * @author Vinod John
 * @Date 04.08.2024
 */
@Data
public class User {
    private String firstName;
    private String lastName;
    private String password;

    private UserType userType;
}
