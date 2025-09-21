package com.banking.core.api.application.services.authentication;

import com.banking.core.api.application.ports.outbound.repositories.role.RoleRepositoryPort;
import com.banking.core.api.application.ports.outbound.services.authentication.AuthenticationServicePort;
import com.banking.core.api.domain.entities.role.Role;
import com.banking.core.api.domain.entities.role.RoleEnum;
import com.banking.core.api.domain.entities.user.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.LoginUserDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.RegisterUserDto;
import com.banking.core.api.infrastructure.adapters.outbound.persistence.user.UserRepositoryAdapter;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@Service
public class AuthenticationService implements AuthenticationServicePort {

    private final UserRepositoryAdapter userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepositoryPort roleRepositoryPort;

    public AuthenticationService(
            UserRepositoryAdapter userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            RoleRepositoryPort roleRepositoryPort
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public User signup(RegisterUserDto input) throws BadRequestException {

        Optional<Role> optionalRole = roleRepositoryPort.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            throw new BadRequestException("Role do not exist");
        }

        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(optionalRole.get());
        return userRepository.save(user);
    }

    @Override
    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
