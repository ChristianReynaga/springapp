package dev.chrislancer.springapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                inMemoryAuthentication()
                .withUser("user").password("{noop}" + "user").roles("USER")
                .and()
                .withUser("admin").password("{noop}" + "admin").roles("ADMIN");
    }

    private void jwtAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(null);
    }

    private void basicAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                inMemoryAuthentication()
                .withUser("user").password("{noop}" + "user").roles("USER")
                .and()
                .withUser("admin").password("{noop}" + "admin").roles("ADMIN");
    }

}
