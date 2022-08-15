package dev.chrislancer.springapp.rest;

import dev.chrislancer.springapp.security.User;
import dev.chrislancer.springapp.security.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    UserRepository userRepo;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/register")
    public void register(@AuthenticationPrincipal UserDetails userDetails, @RequestBody User user) {
        // input validation omitted for brevity
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
        }else {
            log.info("You need ROLE_ADMIN");
        }
    }

}
