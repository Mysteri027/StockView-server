package ru.igor.stockview.service

import org.springframework.stereotype.Service
import ru.igor.stockview.dto.AuthenticationRequest
import ru.igor.stockview.dto.AuthenticationResponse
import ru.igor.stockview.dto.RegisterRequest

@Service
interface AuthenticationService {
    fun register(registerRequest: RegisterRequest): AuthenticationResponse
    fun login(authenticationRequest: AuthenticationRequest): AuthenticationResponse
}