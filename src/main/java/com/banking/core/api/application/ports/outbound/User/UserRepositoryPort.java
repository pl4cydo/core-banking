package com.banking.core.api.application.ports.outbound.User;

import com.banking.core.api.application.ports.outbound.BaseRepositoryPort;
import com.banking.core.api.domain.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositoryPort extends BaseRepositoryPort<User, Long> { }
