package ru.igor.stockview.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.igor.stockview.dto.auth.AuthenticationRequest
import ru.igor.stockview.dto.auth.AuthenticationResponse
import ru.igor.stockview.dto.auth.RegisterRequest
import ru.igor.stockview.exception.UserNotFoundException
import ru.igor.stockview.service.AuthenticationService

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authenticationService: AuthenticationService
) {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException::class)
    fun handleNotFoundException(e: NoSuchElementException): ResponseEntity<Map<String, String?>> {
        return ResponseEntity(mapOf("message" to e.message), HttpStatus.NOT_FOUND)
    }

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): ResponseEntity<AuthenticationResponse> {

        print("${registerRequest.email} ${registerRequest.password}")

        return ResponseEntity.ok(authenticationService.register(registerRequest))
    }

    @PostMapping("/login")
    fun login(@RequestBody authenticationRequest: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {

        print("${authenticationRequest.email} ${authenticationRequest.password}")

        return ResponseEntity.ok(authenticationService.login(authenticationRequest))
    }
}