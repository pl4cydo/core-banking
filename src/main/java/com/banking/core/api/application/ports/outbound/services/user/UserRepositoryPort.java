package com.banking.core.api.application.ports.outbound.services.user;

import com.banking.core.api.application.ports.outbound.repositories.BaseRepositoryPort;
import com.banking.core.api.domain.entities.User;

public interface UserRepositoryPort extends BaseRepositoryPort<User, Long> { }
