package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.CustomUserDetails;
import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository ur){
        this.userRepository=ur;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("User Not found"));
        return new CustomUserDetails(user);
    }
}
