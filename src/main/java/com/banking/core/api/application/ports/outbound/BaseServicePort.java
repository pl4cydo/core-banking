package com.banking.core.api.application.ports.outbound;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaseServicePort<T, Long> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
    Long update(Long id, T entity);
}
