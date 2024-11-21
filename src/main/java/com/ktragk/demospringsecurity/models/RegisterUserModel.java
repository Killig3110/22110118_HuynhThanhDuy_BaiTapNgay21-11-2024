package com.ktragk.demospringsecurity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserModel {
    private String email;
    private String password;
    private String fullName;
    private String images;
}
