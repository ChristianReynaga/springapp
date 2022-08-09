package dev.chrislancer.springapp.config;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class UserDetails implements UserDetailsService {
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Map<String, String> users = new HashMap();
        users.put("user", "user");
        users.put("admin", "admin");
        return null;
    }
}
