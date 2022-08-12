package dev.chrislancer.springapp.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AuthRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;
    private String password;

}
