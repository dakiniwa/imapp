package com.example.imapp.web.users;

import com.example.imapp.web.validation.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

    @NotBlank
    @UniqueUsername
    private String username;
    
    @NotBlank
    @Size(min = 12, max = 128)
    private String password;
}
