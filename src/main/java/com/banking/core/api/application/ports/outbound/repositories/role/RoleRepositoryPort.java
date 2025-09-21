package com.banking.core.api.application.ports.outbound.repositories.role;

import com.banking.core.api.application.ports.outbound.repositories.BaseRepositoryPort;
import com.banking.core.api.domain.entities.role.Role;
import com.banking.core.api.domain.entities.role.RoleEnum;

import java.util.Optional;

public interface RoleRepositoryPort extends BaseRepositoryPort<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
