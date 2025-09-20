package com.banking.core.api.application.ports.mapper.user;

import com.banking.core.api.application.ports.mapper.BaseMapper;
import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.ResponseUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseUserMapper extends BaseMapper<User, ResponseUserDto> {}