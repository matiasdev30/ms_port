package com.ms_user.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserModelDTO(@NotBlank String name, @NotBlank @Email String email) {
    
}
