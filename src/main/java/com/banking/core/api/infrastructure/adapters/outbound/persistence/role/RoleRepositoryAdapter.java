package com.banking.core.api.infrastructure.adapters.outbound.persistence.role;

import com.banking.core.api.application.ports.outbound.repositories.role.RoleRepositoryPort;
import com.banking.core.api.domain.entities.role.Role;
import com.banking.core.api.domain.entities.role.RoleEnum;
import com.banking.core.api.infrastructure.adapters.outbound.persistence.BaseRepositoryAdapter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepositoryAdapter extends BaseRepositoryAdapter<Role> implements RoleRepositoryPort {

    public RoleRepositoryAdapter() {
        super(Role.class);
    }

    @Override
    public Optional<Role> findByName(RoleEnum name) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class)
                .setParameter("name", name)
                .getResultStream()
                .findFirst();
    }
}
