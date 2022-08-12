package dev.chrislancer.springapp.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private String role; // should be prefixed with ROLE_

}
