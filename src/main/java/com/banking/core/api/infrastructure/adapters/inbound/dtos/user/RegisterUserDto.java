package com.banking.core.api.infrastructure.adapters.inbound.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
    private String name;
    private String email;
    private String password;
}
