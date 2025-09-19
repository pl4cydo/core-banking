package com.banking.core.api.application.ports.mappers.user;

import com.banking.core.api.application.ports.mappers.BaseMapper;
import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.UserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper extends BaseMapper<User, UserRequestDto> {}
