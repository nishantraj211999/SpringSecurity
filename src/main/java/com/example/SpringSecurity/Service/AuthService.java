package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.DTO.UserRegisterRequestDto;
import com.example.SpringSecurity.DTO.UserRegisterResponseDto;
import com.example.SpringSecurity.Entity.Role;
import com.example.SpringSecurity.Entity.User;
import com.example.SpringSecurity.repository.RoleRepository;
import com.example.SpringSecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository repository,RoleRepository roleRepository, PasswordEncoder pe){
     this.userRepository=repository;
     this.roleRepository=roleRepository;
     this.passwordEncoder=pe;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto){
        User user=new User();
        user.setUserName(registerRequestDto.getUserName());
        user.setUserPassword(passwordEncoder.encode(registerRequestDto.getUserPassword()));
        user.setEnabled(true);

        Role role=roleRepository.findByName("ROLE_USER").get();
        user.getRoles().add(role);

        userRepository.save(user);

        //response
        UserRegisterResponseDto registerResponseDto=new UserRegisterResponseDto();
        registerResponseDto.setUserName(user.getUserName());
        registerResponseDto.setMessage("user save successFully wow have a nice day");
        return  registerResponseDto;

    }
}
