package com.banking.core.api.application.ports.outbound;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaseServicePort<ResponseDto, RequestDto, Long> {
    Long save(RequestDto dto);
    ResponseDto findById(Long id);
    List<ResponseDto> findAll();
    void deleteById(Long id);
    Long update(Long id, RequestDto dto);
}
