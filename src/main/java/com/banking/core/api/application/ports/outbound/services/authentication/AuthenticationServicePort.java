package com.banking.core.api.application.ports.outbound.services.authentication;

import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.LoginUserDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.RegisterUserDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationServicePort {
    User signup(RegisterUserDto input);
    User authenticate(LoginUserDto input);
}
