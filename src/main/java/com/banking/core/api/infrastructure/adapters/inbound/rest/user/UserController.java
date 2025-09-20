package com.banking.core.api.infrastructure.adapters.inbound.rest.user;

import com.banking.core.api.application.ports.outbound.services.BaseServicePort;
import com.banking.core.api.application.services.user.UserService;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.RegisterUserDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.ResponseUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final BaseServicePort<ResponseUserDto, RegisterUserDto, Long> userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseUserDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody RegisterUserDto entity) {
        return new ResponseEntity<>(userService.save(entity), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody RegisterUserDto entity) {
        return new ResponseEntity<>(userService.update(id, entity), HttpStatus.OK);
    }
}
