package com.banking.core.api.application.ports.mapper;

import org.mapstruct.Mapper;

import java.util.List;


public interface BaseMapper<Entity, Dto> {
    Dto entityToDto(Entity entity);
    Entity dtoToEntity(Dto dto);
    List<Dto> entityToDto(List<Entity> entities);
}
