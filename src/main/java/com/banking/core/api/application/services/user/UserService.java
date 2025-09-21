package com.banking.core.api.application.services.user;

import com.banking.core.api.infrastructure.adapters.inbound.mapper.user.ResponseUserMapper;
import com.banking.core.api.application.ports.outbound.repositories.user.UserRepositoryPort;
import com.banking.core.api.application.ports.outbound.services.BaseServicePort;
import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.RegisterUserDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.ResponseUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements BaseServicePort<ResponseUserDto, RegisterUserDto, Long> {

    private final UserRepositoryPort userRepository;
    private final ResponseUserMapper responseUserDto;

    public UserService(UserRepositoryPort userRepository, ResponseUserMapper responseUserDto) {
        this.userRepository = userRepository;
        this.responseUserDto = responseUserDto;
    }

    @Override
    public Long save(RegisterUserDto registerUserDto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseUserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return responseUserDto.entityToDto(user);
    }

    @Override
    public List<ResponseUserDto> findAll() {
        return responseUserDto.entityToDto(userRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public Long update(Long id, RegisterUserDto userRequestDto) {
        User user =  userRepository.findById(id)
                .orElseThrow();

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());

        return userRepository.save(user).getId();
    }

}
