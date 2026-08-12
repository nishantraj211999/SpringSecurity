package com.example.SpringSecurity.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequestDto {

    private String userName;
    private String userPassword;
}
