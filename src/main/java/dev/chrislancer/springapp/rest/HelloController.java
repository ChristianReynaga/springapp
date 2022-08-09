package dev.chrislancer.springapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/public")
    public ResponseEntity<?> helloWorld() {
        logAuthentication();
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/info")
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
        logger.info("USER: {}", auth.getPrincipal());
        logger.info("AUTHORITIES: {}", auth.getAuthorities());
        logger.info("IS AUTHENTICATED: {}", auth.isAuthenticated());
    }

}
