package com.banking.core.api.infrastructure.adapters.outbound.persistence;

import com.banking.core.api.application.ports.outbound.repositories.BaseRepositoryPort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseRepositoryAdapter<T> implements BaseRepositoryPort<T, Long> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public BaseRepositoryAdapter(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        if (entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity) == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public List<T> findAll() {
        String query = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(query, entityClass).getResultList();
    }

    @Override
    public void delete(Long id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
