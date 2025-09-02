package com.banking.core.api.application.services.User;

import com.banking.core.api.application.ports.outbound.User.UserRepositoryPort;
import com.banking.core.api.application.ports.outbound.User.UserServicePort;
import com.banking.core.api.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServicePort {

    private final UserRepositoryPort userRepository;

    public UserService(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Long update(Long id, User userUpdated) {
        User user =  userRepository.findById(id)
                .orElseThrow(); // TODO: Impementar exception;

        user.setNome(userUpdated.getNome());
        user.setEmail(userUpdated.getEmail());

        return userRepository.save(user).getId();
    }

    public Optional<User> findById(Long id) {
        return Optional.of(userRepository.findById(id)
                .orElseThrow());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.delete(id);
    }
}
