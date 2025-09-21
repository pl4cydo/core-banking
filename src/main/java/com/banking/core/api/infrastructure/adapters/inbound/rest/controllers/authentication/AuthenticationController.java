package com.banking.core.api.infrastructure.adapters.inbound.rest.controllers.authentication;

import com.banking.core.api.application.ports.outbound.services.authentication.AuthenticationServicePort;
import com.banking.core.api.application.services.jwt.JwtService;
import com.banking.core.api.domain.entities.LoginResponse;
import com.banking.core.api.domain.entities.User;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.LoginUserDto;
import com.banking.core.api.infrastructure.adapters.inbound.dtos.user.RegisterUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
@Controller
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationServicePort authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationServicePort authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/singup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
