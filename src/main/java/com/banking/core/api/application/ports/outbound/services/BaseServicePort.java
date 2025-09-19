package com.banking.core.api.application.ports.outbound.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseServicePort<ResponseDto, RequestDto, Long> {
    Long save(RequestDto dto);
    ResponseDto findById(Long id);
    List<ResponseDto> findAll();
    void deleteById(Long id);
    Long update(Long id, RequestDto dto);
}
