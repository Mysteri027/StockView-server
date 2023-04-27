package ru.igor.stockview.service

import org.springframework.stereotype.Service
import ru.igor.stockview.dto.auth.AuthenticationRequest
import ru.igor.stockview.dto.auth.AuthenticationResponse
import ru.igor.stockview.dto.auth.RegisterRequest

@Service
interface AuthenticationService {
    fun register(registerRequest: RegisterRequest): AuthenticationResponse
    fun login(authenticationRequest: AuthenticationRequest): AuthenticationResponse
}