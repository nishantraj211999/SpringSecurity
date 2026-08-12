package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.DTO.UserRegisterRequestDto;
import com.example.SpringSecurity.DTO.UserRegisterResponseDto;
import com.example.SpringSecurity.Service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private AuthService authService;

    public UserController(AuthService as){
        this.authService=as;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>register(@RequestBody UserRegisterRequestDto userRegisterRequestDto){
        UserRegisterResponseDto userRegisterResponseDto= authService.register(userRegisterRequestDto);
        return ResponseEntity.ok(userRegisterResponseDto);
    }

    @GetMapping
    public ResponseEntity<String>sayHello(){
        return ResponseEntity.ok("DONE");
    }

}
