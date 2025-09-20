package com.banking.core.api.application.ports.outbound.repositories.user;

import com.banking.core.api.application.ports.outbound.repositories.BaseRepositoryPort;
import com.banking.core.api.domain.entities.User;

import java.util.Optional;

public interface UserRepositoryPort extends BaseRepositoryPort<User, Long> {
    Optional<User> findByEmail(String email);
}
