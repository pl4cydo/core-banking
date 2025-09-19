package com.banking.core.api.application.ports.outbound.repositories.user;

import com.banking.core.api.application.ports.outbound.services.BaseServicePort;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.UserRequestDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserServicePort extends BaseServicePort<UserResponseDto, UserRequestDto, Long> {}
