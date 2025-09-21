package com.banking.core.api.application.ports.outbound.services.authentication;

import com.banking.core.api.domain.entities.user.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.LoginUserDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.RegisterUserDto;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

public interface AuthenticationServicePort {
    User signup(RegisterUserDto input) throws BadRequestException;
    User authenticate(LoginUserDto input);
}
