package com.banking.core.api.application.ports.outbound.User;

import com.banking.core.api.application.ports.outbound.BaseServicePort;
import com.banking.core.api.domain.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServicePort extends BaseServicePort<User, Long> {
}
