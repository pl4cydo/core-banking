package com.banking.core.api.domain.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private long expiresIn;
    public String getToken() {
        return token;
    }
}
