package com.example.SpringSecurity.config;

import com.example.SpringSecurity.Entity.CustomUserDetails;
import com.example.SpringSecurity.Service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder){

    DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider(customUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, DaoAuthenticationProvider provider){

        httpSecurity.csrf(csrf->csrf.disable())
                .authenticationProvider(provider)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth->
                        auth.requestMatchers("/api/user/register").permitAll()
                        .requestMatchers("/api/roles").permitAll()
                                .anyRequest().authenticated());
        return httpSecurity.build();
    }
}
