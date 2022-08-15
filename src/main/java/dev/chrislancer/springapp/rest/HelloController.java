package dev.chrislancer.springapp.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class HelloController {

    @GetMapping("/user")
    public ResponseEntity<?> helloUser() {
        logAuthentication();
        return ResponseEntity.ok("Hello User");
    }

    @GetMapping("/admin")
    public ResponseEntity<?> helloAdmin() {
        logAuthentication();
        return ResponseEntity.ok("Hello Admin");
    }



    private void logAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("USER: {}", auth.getPrincipal());
        log.info("AUTHORITIES: {}", auth.getAuthorities());
        log.info("IS AUTHENTICATED: {}", auth.isAuthenticated());
    }

}
