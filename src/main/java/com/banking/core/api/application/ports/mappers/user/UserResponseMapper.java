package com.banking.core.api.application.ports.mappers.user;

import com.banking.core.api.application.ports.mappers.BaseMapper;
import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper extends BaseMapper<User, UserResponseDto> {}
