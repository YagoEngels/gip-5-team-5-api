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

    //urls for only users
    private static final String[] semi_SECURED_Urls = {
            "/api/v1/item/update/{id}",
            "/api/v1/item/add",
            "/api/v1/item/get/{id}",
            "/api/v1/item/getall",
            "/api/v1/item/delete/{id}",
            "/api/v1/item/update/{id}/{actie}/{amount}"
    };
    //urls for admins
    private static final String[] SECURED_Urls = {
            "/api/v1/user/getall",
            "/api/v1/user/update/{id}",
            "/api/v1/user/addadmin",
            "/api/v1/user/promoteAdmin/{id}",
            "/api/v1/user/demoteAdmin/{id}"
    };
    //urls for everybody
    private static final String[] UN_SECURED_Urls = {
            "/api/v1/user/adduser"
    };

    //om password te encode
    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(UN_SECURED_Urls)
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(SECURED_Urls)
                .hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and().httpBasic()
                .and().build();
    }
}