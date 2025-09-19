package com.banking.core.api.application.services.User;

import com.banking.core.api.application.ports.mappers.user.UserRequestMapper;
import com.banking.core.api.application.ports.mappers.user.UserResponseMapper;
import com.banking.core.api.application.ports.outbound.services.user.UserRepositoryPort;
import com.banking.core.api.application.ports.outbound.repositories.user.UserServicePort;
import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.UserRequestDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServicePort {

    private final UserRepositoryPort userRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    public UserService(UserRepositoryPort userRepository, UserResponseMapper userResponseMapper, UserRequestMapper userRequestMapper) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
    }

    @Override
    public Long save(UserRequestDto userRequestDto) {
        User newUser = userRequestMapper.dtoToEntity(userRequestDto);
        User user = userRepository.save(newUser);
        return user.getId();
    }

    @Override
    public UserResponseDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userResponseMapper.entityToDto(user);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userResponseMapper.entityToDto(userRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public Long update(Long id, UserRequestDto userRequestDto) {
        User user =  userRepository.findById(id)
                .orElseThrow(); // TODO: Impementar exception;

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());

        return userRepository.save(user).getId();
    }

}
