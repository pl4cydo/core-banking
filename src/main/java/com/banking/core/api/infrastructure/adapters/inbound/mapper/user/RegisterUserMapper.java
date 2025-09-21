package com.banking.core.api.infrastructure.adapters.inbound.mapper.user;

import com.banking.core.api.infrastructure.adapters.inbound.mapper.BaseMapper;
import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.RegisterUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterUserMapper extends BaseMapper<User, RegisterUserDto> {}