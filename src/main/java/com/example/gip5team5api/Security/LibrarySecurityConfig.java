package com.example.gip5team5api.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class LibrarySecurityConfig {

    private static final String[] SECURED_Urls = {
            "/api/v1/inventory/**"
    };
    private static final String[] UN_SECURED_Urls = {
            "/api/v1/inventory",
            "api/v1/user/**"
    };

    //om password te encode
    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(UN_SECURED_Urls).permitAll().and()
                .authorizeHttpRequests().requestMatchers(SECURED_Urls)
                .hasAuthority("ADMIN").anyRequest()
                .authenticated().and().httpBasic().and().build();
    }
}
