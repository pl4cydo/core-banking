package com.banking.core.api.infrastructure.adapters.outbound.persistence.user;

import com.banking.core.api.application.ports.outbound.repositories.user.UserRepositoryPort;
import com.banking.core.api.domain.entities.user.User;
import com.banking.core.api.infrastructure.adapters.outbound.persistence.BaseRepositoryAdapter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter extends BaseRepositoryAdapter<User> implements UserRepositoryPort {

    public UserRepositoryAdapter() {
        super(User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
