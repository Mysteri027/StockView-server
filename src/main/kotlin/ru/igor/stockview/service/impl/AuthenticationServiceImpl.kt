package ru.igor.stockview.service.impl

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.igor.stockview.config.JwtService
import ru.igor.stockview.dto.AuthenticationRequest
import ru.igor.stockview.dto.AuthenticationResponse
import ru.igor.stockview.dto.RegisterRequest
import ru.igor.stockview.entity.Role
import ru.igor.stockview.entity.UserEntity
import ru.igor.stockview.exception.UserNotFoundException
import ru.igor.stockview.repository.UserRepository
import ru.igor.stockview.service.AuthenticationService

@Service
class AuthenticationServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) : AuthenticationService {
    override fun register(registerRequest: RegisterRequest): AuthenticationResponse {
        val user = UserEntity(
            email = registerRequest.email,
            password = passwordEncoder.encode(registerRequest.password),
            role = Role.USER
        )

        userRepository.save(user)

        val jwt = jwtService.generateToken(user)

        return AuthenticationResponse(token = jwt)
    }

    override fun login(authenticationRequest: AuthenticationRequest): AuthenticationResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authenticationRequest.email,
                authenticationRequest.password
            )
        )

        val user =
            userRepository.findByEmail(authenticationRequest.email) ?: throw UserNotFoundException("User nor found")

        val jwt = jwtService.generateToken(user)
        return AuthenticationResponse(token = jwt)
    }
}